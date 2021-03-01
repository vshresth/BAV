package io.swagger.service;


import io.swagger.Exception.CustomErrorException;
import io.swagger.Exception.PhixiusCustomException;
import io.swagger.Util.Cryptography;
import io.swagger.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


@Service
public class VerifyAccountServiceImpl implements VerifyAccountService{
    private static final Logger log = LoggerFactory.getLogger(VerifyAccountServiceImpl.class);

    @Value("${test.user}")
    private String testUser;
    @Value("${test.pwd}")
    private String testPwd;

    @Autowired
    HeaderBean headerBean;
    @Autowired
    SwiftRefServiceImpl swiftRefService;

    PhixiusServiceImpl phixiusService = new PhixiusServiceImpl();

    @Override
    public AccountVerificationResponse1 verifyAccountService(AccountVerificationRequest body) {

        //headers
        String xbic = headerBean.getXbic();
        String inst = headerBean.getInstitution();
        String subDN = headerBean.getSubjectDN();

        log.info("xbic: "+xbic, "\n inst: "+inst, "\n subDN "+subDN);

        //user-credential
        String userCredentials = testUser+":"+Cryptography.decrypt(testPwd);
        String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));

        try{
            List<String>  refId = new ArrayList<>();
            log.info("checkMemberID in request ");
            String memberID = body.getCreditorAgent().getClearingSystemMemberIdentification().getClearingSystemIdentification().getCode();
            if(memberID ==null || memberID.isEmpty() || memberID.equals("") || memberID.equals(" ")) {
                log.info("checkMemberID is not in request ");
                log.info("Swift Ref Data calls ");
                RefDataResponse refDataResponseNationalIds = swiftRefService.getSwiftRefData(xbic);
                refId = swiftRefService.parseSwiftRefRespID(refDataResponseNationalIds);
                log.info("refID"+ refId);
                if(refId == null || refId.isEmpty() ) {
                    log.error("no values returned from swift ref call");
                    throw new CustomErrorException("no swiftref data");
                }
                log.info("refID"+ refId);
                log.info("Swift Ref Data Response"+ refDataResponseNationalIds.toString());

            } else {
                log.info("checkMemberID from request ");
                refId.add(memberID);
            }

           for(int i=0; i <= refId.size()-1;i++){

               String id = refId.get(i);
               //send basicauth, refid, account number from initial request body, clearing system identification
               PhixiusResponse phixiusResponse  = phixiusService.phixiusResponseCall(id);
               log.info("newResponse "+ phixiusResponse);

               if((phixiusResponse.getAccountStatus().equals("Enabled") || phixiusResponse.getAccountStatus().equals("Disabled") || phixiusResponse.getAccountStatus().equals("NOT Found"))){
                   AccountVerificationResponse1 newAccV = objectMapper(phixiusResponse,body);
                    return newAccV;
                }else if (i == refId.size()-1){
                    throw new PhixiusCustomException();
                 }
           }
        }catch (Exception e) {
                 log.error("Webclient error",e.getMessage());
                log.error("no valid response found");
        }
        return null;
    }


    public AccountVerificationResponse1 objectMapper(PhixiusResponse newResponse, AccountVerificationRequest accountVerificationRequest) {
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
        newAccV.setCorrelationIdentifier(accountVerificationRequest.getCorrelationIdentifier());
        newAccV.setResponse(newVCR);

        return newAccV;
    }

}
