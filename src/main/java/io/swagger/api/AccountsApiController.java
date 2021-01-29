package io.swagger.api;

import io.swagger.model.AccountVerificationRequest;
import io.swagger.model.AccountVerificationResponse1;
import io.swagger.model.ErrorCodeProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.service.VerifyAccountService;
import io.swagger.service.VerifyAccountServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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
        String xbic = request.getHeader("x-bic");
        String subDN = request.getHeader("SubjectDN");
        String inst = request.getHeader("Institution");
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-bic", xbic);
        headers.add("SubjectDN", subDN);
        headers.add("Institution", inst);
        headers.add("Accept", accept);

        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<AccountVerificationResponse1>(verifyAccountServiceImpl.verifyAccountService(body, headers),headers, HttpStatus.OK);

            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<AccountVerificationResponse1>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<AccountVerificationResponse1>(HttpStatus.NOT_IMPLEMENTED);
    }

}
