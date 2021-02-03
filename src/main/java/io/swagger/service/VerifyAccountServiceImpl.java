package io.swagger.service;


import io.swagger.Util.Cryptography;
import io.swagger.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
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
import java.util.Base64;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class VerifyAccountServiceImpl implements VerifyAccountService{
    private static final Logger log = LoggerFactory.getLogger(VerifyAccountServiceImpl.class);

    @Value("${test.url}")
    private String testUrl;
    @Value("${test.user}")
    private String testUser;
    @Value("${test.pwd}")
    private String testPwd;

    private final WebClient webClient;
    @Autowired
    public VerifyAccountServiceImpl() {
        this.webClient = WebClient.builder().baseUrl(testUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                .build();
        log.info("in const 1:");
    }


    @Override
    public AccountVerificationResponse1 verifyAccountService(AccountVerificationRequest body) {

        log.info("End URL is: " + testUrl);
        HeaderBean headerBean=CustomSpringBean.getHeaderBean();
        StringBuilder response = new StringBuilder();
        String responseLine = null;

        //headers
        String xbic = headerBean.getXbic();
        String inst = headerBean.getInstitution();
        String subDN = headerBean.getSubjectDN();

        log.info("xbic: "+xbic);
        log.info("inst: "+inst);
        log.info("subDN "+subDN);
        //user-credential
        String userCredentials = testUser+":"+Cryptography.decrypt(testPwd);;
        String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));
        
        try {
            PhixiusRequest preq = new PhixiusRequest ("ram", "programmer");
            //WebClient
            PhixiusResponse newResponse= webClient.post()
                        .uri(testUrl)
                        .header("x-bic", xbic)
                        .header("SubjectDN", subDN)
                        .header("Institution", inst)
                      //  .header("Authorization", basicAuth)
                        .header("Accept", "application/json")
                        .header("User-Agent", "Mozilla/4.76")
                        .body(Mono.just(preq), PhixiusRequest.class)
                        .retrieve()
                        .bodyToMono(PhixiusResponse.class)
                        .block();

            log.info("Mock response" + newResponse.toString());
            AccountVerificationResponse1 newAccV = objectMapper(newResponse);
            log.info("hardcoded with mapper response" + newAccV.toString());
            return newAccV;

        }catch (Exception e) {
                log.error("Webclient error", e.getStackTrace());
                log.error("Webclient error", e);

        }
        return null;
    }

    private AccountVerificationResponse1 objectMapper(PhixiusResponse newResponse) {
        AccountVerificationResponse1 newAccV = new AccountVerificationResponse1();
        ValidationCheckReponse1 newVCR = new ValidationCheckReponse1();

        newVCR.setAccountValidationStatus(newResponse.getAccountValidationStatus());
        newVCR.setCreditorAccountMatch(newResponse.getCreditorAccountMatch());
        newVCR.creditorNameMatch(newResponse.getCreditorNameMatch());
        newVCR.setCreditorAddressMatch(newResponse.getCreditorAddressMatch());
        newVCR.setCreditorOrganisationIdentificationMatch(newResponse.getCreditorOrganisationIdentificationMatch());
        newAccV.setCorrelationIdentifier(newResponse.getCorrelationIdentifier());
        newAccV.setResponse(newVCR);

        return newAccV;
    }

    @Override
    public AccountVerificationResponse1 verifyAccountService(AccountVerificationRequest body, HttpHeaders headers) {
        return null;
    }
    @Override
    public AccountVerificationResponse1 verifyAccountService(AccountVerificationRequest body, String xbic, String subDN, String inst) {
        log.info("End URL is: " + testUrl);
        StringBuilder response = new StringBuilder();
        String responseLine = null;
        AccountVerificationResponse1 newAccV = new AccountVerificationResponse1();
        ValidationCheckReponse1 newVCR = new ValidationCheckReponse1();

        try {

            //headers
           // String xbic = headerBean.getXbic();
           // String inst = headerBean.getInstitution();
            //String subDN = headerBean.getSubjectDN();

            log.info("xbic: "+xbic);
            log.info("inst: "+inst);
            log.info("subDN "+subDN);
            //user-credential
            String userCredentials = testUser+":"+Cryptography.decrypt(testPwd);;
            String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));

            //create connection to the endpoint
            URL url = new URL(testUrl);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            //set headers
            con.addRequestProperty("User-Agent", "Mozilla/4.76"); // only for this dummy url
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty ("Accept", "application/json");
            con.setRequestProperty ("x-bic", xbic);
            con.setRequestProperty ("SubjectDN", subDN);
            con.setRequestProperty ("Institution", inst);
            // con.setRequestProperty ("Authorization", basicAuth);


            con.setUseCaches(false);
            con.setDoOutput(true);
            con.setReadTimeout(5000);
            con.setInstanceFollowRedirects(true);
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            // send the input message body
            String jsonInputString = body.toString();
            log.info(":Actual input: " +jsonInputString);
            String testString = "{\"name\": \"Ram\", \"job\": \"Programmer\"}";
            log.info("Sample string: " + testString);

            try(OutputStream os = con.getOutputStream()){
                byte[] input = testString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            } catch (Exception e) {
                log.error("error with input json", e);

            }


            //get response status
            int status = con.getResponseCode();
            log.info("Status is: " +  status);
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            while ((responseLine = in.readLine()) != null) {
                response.append(responseLine.trim());
            }
            log.info("Response from server is: " +response.toString());

            log.info("Closing connections");
            in.close();
            con.disconnect();


        } catch (IOException e) {
            log.error("Connection error", e);


        }catch (Exception e) {
            log.error("other error", e);


        }

        //hard coding values

        newVCR.setAccountValidationStatus(AccountValidationResponse3Code.PASS);
        newVCR.setCreditorAccountMatch(AccountValidationResponse2Code.NMTC);
        newVCR.creditorNameMatch(AccountValidationResponse1Code.NOTC);
        newVCR.setCreditorAddressMatch(AccountValidationResponse1Code.NOTC);
        newVCR.setCreditorOrganisationIdentificationMatch(AccountValidationResponse1Code.NOTC);
        newAccV.setCorrelationIdentifier("CORRID-003");
        newAccV.setResponse(newVCR);

        return newAccV;

    }

}
