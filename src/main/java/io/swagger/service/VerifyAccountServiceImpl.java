package io.swagger.service;


import io.swagger.Exception.CustomErrorException;
import io.swagger.Exception.PhixiusCustomException;
import io.swagger.Util.Cryptography;
import io.swagger.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.springframework.cache.annotation.Cacheable;

@Service
public class VerifyAccountServiceImpl implements VerifyAccountService{
    private static final Logger log = LoggerFactory.getLogger(VerifyAccountServiceImpl.class);

    @Value("${test.url}")
    private String testUrl;
    @Value("${test.user}")
    private String testUser;
    @Value("${test.pwd}")
    private String testPwd;
    @Value("${refdata.url}")
    private String refDataUrl;
    @Value("${refdata.pwd}")
    private String refDataPwd;

    private final WebClient webClient;
    private final WebClient refWebClient;

    @Autowired
    public VerifyAccountServiceImpl() {
        this.webClient = WebClient.builder().baseUrl(testUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                .build();
        log.info("in const:");
        this.refWebClient = WebClient.builder().baseUrl(refDataUrl).defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
    }

    @Autowired
    PhixiusResponse phixiusResponse;
    @Autowired
    PhixiusRequest phixiusRequest;
    @Autowired
    HeaderBean headerBean;

    @Override
    public AccountVerificationResponse1 verifyAccountService(AccountVerificationRequest body) {

        // headerBean=CustomSpringBean.getHeaderBean();
        StringBuilder response = new StringBuilder();
        String responseLine = null;

        //headers
        String xbic = headerBean.getXbic();
        String inst = headerBean.getInstitution();
        String subDN = headerBean.getSubjectDN();

        log.info("End URL is: " + testUrl);
        log.info("xbic: "+xbic);
        log.info("inst: "+inst);
        log.info("subDN "+subDN);
        //user-credential
        String userCredentials = testUser+":"+Cryptography.decrypt(testPwd);;
        String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));


        try{
            log.info("Swift Ref Data calls ");
            RefDataResponse refDataResponseNationalIds = getSwiftRefData(xbic);

           List<Long>  refId = parseSwiftRefRespID(refDataResponseNationalIds);
           if(refId == null || refId.isEmpty() ) {
               log.error("no values returned from swift ref call");
               throw new CustomErrorException("no values returned from swift ref call");
           }

           for(Long id : refId){
               log.info("refID: "+ id);

               phixiusResponse  = phixiusResponseCall(xbic,subDN,inst,basicAuth);
               log.info("newResponse "+ phixiusResponse);
               if((phixiusResponse.getAccountStatus().equals("Enabled") || phixiusResponse.getAccountStatus().equals("Disabled") || phixiusResponse.getAccountStatus().equals("NOT Found"))){
                    AccountVerificationResponse1 newAccV = objectMapper(phixiusResponse);
                    return newAccV;
            }else{
                throw new PhixiusCustomException();
            }

//            log.info("Mock response" + newResponse.toString());
//            AccountVerificationResponse1 newAccV = objectMapper(newResponse);
//            log.info("hardcoded with mapper response" + newAccV.toString());

            }
        }catch (Exception e) {
            log.error("Webclient error: ",e.getMessage());
        }

        return null;
    }

    @Cacheable(value = "swiftRefData")
    public RefDataResponse getSwiftRefData(String xbic) throws CustomErrorException {
        log.info("in the getSwiftRefDataMethod");
        String swiftRefBasicAuth = "Basic " + refDataPwd;
        try {
            RefDataResponse refDataResponseNationalIds = refWebClient.get()
                    .uri(refDataUrl+ xbic + "/national_ids" )
                    .header("Authorization", swiftRefBasicAuth)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .onStatus(HttpStatus::is4xxClientError,
                            error -> Mono.error(new CustomErrorException("ClientResponse has erroneous status code: " + error.statusCode() )))
                    .onStatus(HttpStatus::is5xxServerError,
                            error -> Mono.error(new CustomErrorException("Error with swiftRefServer: "+ error.statusCode())))
                    .bodyToMono(RefDataResponse.class)
                    .block();

            log.info("return from getSwiftRefDataMethod");
            return refDataResponseNationalIds;
        } catch (Exception e) {
            log.error("Error calling swiftRefData: " + e.getMessage());
            throw new CustomErrorException("Error calling swiftRefData: "+e.getMessage() );
        }


    }

    public List<Long> parseSwiftRefRespID(RefDataResponse refDataResponse){

        List<Long> refDataNatlID = new ArrayList<>();
        if(refDataResponse != null && !refDataResponse.getNationalIds().isEmpty()) {
            for (RefDataResponse.NationalIds id : refDataResponse.getNationalIds()) {
                    refDataNatlID.add(id.getId());
                }
            }
        return refDataNatlID;
    }

    public PhixiusResponse phixiusResponseCall(String xbic, String subDn, String inst, String basicAuth){
      //  phixiusRequest  = new PhixiusRequest();
//        PhixiusResponse phixiusResponse = webClient.post()
//                .uri(testUrl)
//                .header("x-bic", xbic)
//                .header("SubjectDN", subDn)
//                .header("Institution", inst)
//                //.header("Authorization", basicAuth)
//                .header("Accept", "application/json")
//                //.header("User-Agent", "Mozilla/4.76")
//                .body(Mono.just(phixiusRequest), PhixiusRequest.class)
//                .retrieve()
//                .bodyToMono(PhixiusResponse.class)
//                .block();

        PhixiusResponse phixiusResponse = new PhixiusResponse();

        phixiusResponse.setAccountStatus("Enabled");
        DebtorAccount debtorAccount = new DebtorAccount();
        debtorAccount.setIdentification("13590100098332");

        DebtorAgent debtorAgent = new DebtorAgent();
        debtorAgent.setMemberIdentification("226078036");
        debtorAgent.setClearingSystemIdentification("USABA");

       // phixiusResponse.setDebtorAccount();
        phixiusResponse.setDebtorAccount(debtorAccount);
        phixiusResponse.setDebtorAgent(debtorAgent);
        return phixiusResponse;
    }

    private AccountVerificationResponse1 objectMapper(PhixiusResponse newResponse) {
        AccountVerificationResponse1 newAccV = new AccountVerificationResponse1();
        ValidationCheckReponse1 newVCR = new ValidationCheckReponse1();
        AccountValidationResponse3Code accountValidationResponse3Code;
        PhixiusBavResponse phixiusBavResponse = new PhixiusBavResponse();

        if(newResponse.getAccountStatus()=="Enabled"){
             accountValidationResponse3Code =  AccountValidationResponse3Code.PASS;
        }else if (newResponse.getAccountStatus()=="Disabled"){
             accountValidationResponse3Code =  AccountValidationResponse3Code.FAIL;
        }else{
             accountValidationResponse3Code =  AccountValidationResponse3Code.INCO;
        }
        newVCR.setAccountValidationStatus(accountValidationResponse3Code);
        newVCR.setCreditorAccountMatch(phixiusBavResponse.getCreditorAccountMatch());
        newVCR.creditorNameMatch(phixiusBavResponse.getCreditorNameMatch());
        newVCR.setCreditorAddressMatch(phixiusBavResponse.getCreditorAddressMatch());
        newVCR.setCreditorOrganisationIdentificationMatch(phixiusBavResponse.getCreditorOrganisationIdentificationMatch());
        newAccV.setCorrelationIdentifier(phixiusBavResponse.getCorrelationIdentifier());
        newAccV.setResponse(newVCR);

        return newAccV;
    }

}
