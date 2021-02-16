package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.AccountVerificationRequest;
import io.swagger.model.AccountVerificationResponse1;
import io.swagger.service.VerifyAccountServiceImpl;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-12-31T21:15:33.955Z[GMT]")
@RestController
public class AccountsApiController implements AccountsApi {

    @Autowired
    private VerifyAccountServiceImpl verifyAccountServiceImpl;


    private static final Logger log = LoggerFactory.getLogger(AccountsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

   @Autowired
    public AccountsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<AccountVerificationResponse1> verifyAccount(@Parameter(in = ParameterIn.HEADER, description = "Describe the BIC for SWIFT to route the request to. Providers get the value from the Gateway and consumers are not required to fill it in." ,required=true,schema=@Schema()) @RequestHeader(value="x-bic", required=true) String xBic, @Parameter(in = ParameterIn.HEADER, description = "Describe the Distinguished Name (DN) of the consumer. Providers get the value from the Gateway and consumers are not required to fill it in." ,required=true,schema=@Schema()) @RequestHeader(value="SubjectDN", required=true) String subjectDN, @Parameter(in = ParameterIn.HEADER, description = "Describe the BIC of the consumer. Providers get the value and consumers are not required to fill it in." ,required=true,schema=@Schema()) @RequestHeader(value="Institution", required=true) String institution, @Parameter(in = ParameterIn.DEFAULT, description = "Verify account details request.", required=true, schema=@Schema()) @Valid @RequestBody AccountVerificationRequest body) {
        log.info("Controller information inside verifyaccount");
        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/json")) {
            try {
                AccountVerificationResponse1 acvResponse = verifyAccountServiceImpl.verifyAccountService(body);
                if (acvResponse == null|| acvResponse.getCorrelationIdentifier().equals("") || acvResponse.getCorrelationIdentifier().isEmpty()) {
                    log.error("error with response");
                    return new ResponseEntity<AccountVerificationResponse1>(HttpStatus.INTERNAL_SERVER_ERROR);
                } else
                return new ResponseEntity<AccountVerificationResponse1>(acvResponse,HttpStatus.OK);


            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<AccountVerificationResponse1>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<AccountVerificationResponse1>(HttpStatus.NOT_IMPLEMENTED);
    }

}
