package io.swagger.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.*;
import io.swagger.service.VerifyAccountService;
import io.swagger.service.VerifyAccountServiceImpl;
import io.swagger.service.VerifyAccountServiceImplTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(AccountsApiController.class)
public class AccountsApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    AccountsApiController accountsApiController ;

    @Mock
    VerifyAccountService verifyAccountService = new VerifyAccountServiceImpl();

    AccountVerificationRequest accountVerificationRequest;

    String xbic = "DEUTDEFFXXX";
    String institution = "cclausb0";
    String subjectDN = "o=cclausb0,o=swift";
    AccountVerificationResponse1 acc;

    @Before
    public void setUp(){

        accountVerificationRequest = new AccountVerificationRequest();
        accountVerificationRequest.setCorrelationIdentifier("CORRID-003");
        accountVerificationRequest.setContext(AccountValidationCheckContext1Code.BENR);
        accountVerificationRequest.setUetr("b916a97d-a699-4f20-b8c2-2b07e2684a27");
        accountVerificationRequest.setCreditorAccount("GB3112000000001987426375");
        accountVerificationRequest.setCreditorName("John Doe");
        PostalAddress26 postalAddress26 = new PostalAddress26();
        postalAddress26.setCountry("GB");
        accountVerificationRequest.setCreditorAddress(postalAddress26);
        OrganisationIdentification8 organisationIdentification8 = new OrganisationIdentification8();
        organisationIdentification8.setAnyBic("DEUTDEFFXXX");
        accountVerificationRequest.setCreditorOrganisationIdentification(organisationIdentification8);

        AccountVerificationResponse1 acc = new AccountVerificationResponse1();
        ValidationCheckReponse1 validationCheckReponse1 = new ValidationCheckReponse1();
        validationCheckReponse1.setAccountValidationStatus(AccountValidationResponse3Code.PASS);
        validationCheckReponse1.setCreditorAccountMatch(AccountValidationResponse2Code.NMTC);
        validationCheckReponse1.setCreditorAddressMatch(AccountValidationResponse1Code.NOTC);
        validationCheckReponse1.setCreditorNameMatch(AccountValidationResponse1Code.NOTC);
        validationCheckReponse1.setCreditorOrganisationIdentificationMatch(AccountValidationResponse1Code.NOTC);
        acc.getCorrelationIdentifier();
        acc.setResponse(validationCheckReponse1);


    }

    @Test
    public void verifyAccount() throws Exception {
        String jsonString = "{\n  \"correlation_identifier\" : \"CORRID-003\",\n  \"response\" : {\n    \"account_validation_status\" : \"PASS\",\n    \"creditor_account_match\" : \"NMTC\",\n    \"creditor_name_match\" : \"NOTC\",\n    \"creditor_address_match\" : \"NOTC\",\n    \"creditor_organisation_identification_match\" : \"NOTC\"\n  }\n}";
        Mockito.when(verifyAccountService.verifyAccountService(accountVerificationRequest)).thenReturn(acc);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/accounts/verification")
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .header("x-bic",xbic)
                .header("SubjectDN",subjectDN)
                .header("Institution",institution)
                .content(asJsonString(accountVerificationRequest)))
                .andExpect(status().isOk());
    }


    public String asJsonString(Object object) throws JsonProcessingException {

            return new ObjectMapper().writeValueAsString(object);
    }


}