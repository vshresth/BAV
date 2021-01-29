package io.swagger.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.*;
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

@Service
public class VerifyAccountServiceImpl implements VerifyAccountService{
    private static final Logger log = LoggerFactory.getLogger(VerifyAccountServiceImpl.class);

    @Value("${test.url}")
    private String testUrl;

    @Override
    public AccountVerificationResponse1 verifyAccountService(AccountVerificationRequest body) {
        return null;
    }
    @Override
    public AccountVerificationResponse1 verifyAccountService(AccountVerificationRequest body, HttpHeaders headers) {

        log.info("End URL is: " + testUrl);
        StringBuilder response = new StringBuilder();
        String responseLine = null;
        AccountVerificationResponse1 newAccV = new AccountVerificationResponse1();
        ValidationCheckReponse1 newVCR = new ValidationCheckReponse1();

        try {

            //get all headers first
            String accept = headers.getFirst("Accept");
            String xbic = headers.getFirst("x-bic");
            String subDN = headers.getFirst("SubjectDN");
            String inst = headers.getFirst("Institution");
            String userCredentials = "username:password";
            String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));

            //create connection to the endpoint
            URL url = new URL(testUrl);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            //set headers
            con.addRequestProperty("User-Agent", "Mozilla/4.76");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty ("Accept", accept);
            //con.setRequestProperty ("x-bic", xbic);
            //con.setRequestProperty ("SubjectDN", subDN);
           // con.setRequestProperty ("Institution", inst);
            //con.setRequestProperty ("Authorization", basicAuth);
            con.setUseCaches(false);
            con.setDoOutput(true);
            con.setReadTimeout(5000);
            con.setInstanceFollowRedirects(true);
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            // send the input message body
            String jsonInputString = body.toString();
            log.info(":Actual input: " +jsonInputString);
            String testString = "{\"name\": \"Upendra\", \"job\": \"Programmer\"}";
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
