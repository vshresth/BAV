package io.swagger.service;

import io.swagger.Exception.CustomErrorException;
import io.swagger.Util.Cryptography;
import io.swagger.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class VerifyAccountServiceImplTest {

    private String testUser;
    private String testPwd ;

    String xbic = "DEUTDEFFXXX";
    String inst = "cclausb0";
    String subDN = "o=cclausb0,o=swift";
    String userCredentials = testUser + ":" + Cryptography.decrypt(testUser);
    String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));

    @InjectMocks
    VerifyAccountServiceImpl verifyAccountService;
    @Mock
    SwiftRefServiceImpl swiftRefService;
    //@Mock
   // PhixiusService phixiusService;
    @Mock
    HeaderBean headerBean;

    RefDataResponse refDataResponseExpected;
    List<String> refId;

   // PhixiusResponse phixiusResponse;



    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        // Mocking data for Swift Ref api
        refDataResponseExpected = new RefDataResponse();
        RefDataResponse.NationalIds nationalIds = new RefDataResponse.NationalIds();
        RefDataResponse.NationalIds nationalIds2 = new RefDataResponse.NationalIds();
        RefDataResponse.NationalIds nationalIds3 = new RefDataResponse.NationalIds();
        RefDataResponse.NationalIds nationalIds4 = new RefDataResponse.NationalIds();

        List<RefDataResponse.NationalIds> nationalIdsList = new ArrayList<RefDataResponse.NationalIds>();
        nationalIds.setId("50070010");
        nationalIds.setScheme("BLZ");
        nationalIdsList.add(nationalIds);
        nationalIds2.setId("23070700");
        nationalIds2.setScheme("BLZ");
        nationalIdsList.add(nationalIds2);
        nationalIds3.setId("226078036");
        nationalIds3.setScheme("BLZ");
        nationalIdsList.add(nationalIds3);
        nationalIds4.setId("226078037");
        nationalIds4.setScheme("BLZ");
        nationalIdsList.add(nationalIds4);
        refDataResponseExpected.setNationalIds(nationalIdsList);

        //mocking data for swift ref sorted national id's
        refId = new ArrayList<>();
        refId.add(nationalIds.getId());
        refId.add(nationalIds2.getId());
        refId.add(nationalIds3.getId());
        refId.add(nationalIds4.getId());

        //mocking data for phixius response
//        DebtorAccount debtorAccount = new DebtorAccount();
//        debtorAccount.setIdentification("13590100098332");
//        DebtorAgent debtorAgent = new DebtorAgent();
//        debtorAgent.setMemberIdentification("226078036");
//        debtorAgent.setClearingSystemIdentification("USABA");

       // phixiusResponse = new PhixiusResponse();
//        phixiusResponse.setAccountStatus("Enabled");
//        phixiusResponse.setDebtorAccount(debtorAccount);
//        phixiusResponse.setDebtorAgent(debtorAgent);

        ReflectionTestUtils.setField(verifyAccountService, "testUser", "ram");
        ReflectionTestUtils.setField(verifyAccountService, "testPwd", "E6QN1mwgB7xsyphgdD1uLu9k2khE/vhM4jG5BfNySXc=");

    }


    @Test
    public void verifyAccountService() {

        Mockito.when(swiftRefService.getSwiftRefData(xbic)).thenReturn(refDataResponseExpected);
        Mockito.when(swiftRefService.parseSwiftRefRespID(refDataResponseExpected)).thenReturn(refId);
        //Mockito.when(phixiusService.phixiusResponseCall(xbic,subDN,inst,basicAuth)).thenReturn(phixiusResponse);
        Mockito.when(headerBean.getXbic()).thenReturn(xbic);
        Mockito.when(headerBean.getSubjectDN()).thenReturn(subDN);
        Mockito.when(headerBean.getInstitution()).thenReturn(inst);

        AccountVerificationRequest accountVerificationRequest = new AccountVerificationRequest();
        accountVerificationRequest.setCorrelationIdentifier("CORRID-003");


        AccountVerificationResponse1 acc = verifyAccountService.verifyAccountService(accountVerificationRequest);
        Assert.assertEquals("CORRID-003", acc.getCorrelationIdentifier());
        Assert.assertEquals(AccountValidationResponse3Code.PASS, acc.getResponse().getAccountValidationStatus());
        Assert.assertEquals(AccountValidationResponse2Code.NMTC, acc.getResponse().getCreditorAccountMatch());
        Assert.assertEquals((AccountValidationResponse1Code.NOTC), acc.getResponse().getCreditorNameMatch());
        Assert.assertEquals(AccountValidationResponse1Code.NOTC, acc.getResponse().getCreditorAddressMatch());
        Assert.assertEquals(AccountValidationResponse1Code.NOTC, acc.getResponse().getCreditorOrganisationIdentificationMatch());
        Assert.assertNotNull(null, acc);

    }
}