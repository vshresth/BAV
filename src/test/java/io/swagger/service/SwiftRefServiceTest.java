package io.swagger.service;

import io.swagger.model.RefDataResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SwiftRefServiceTest {

    @InjectMocks
    private SwiftRefService swiftRefService = new SwiftRefServiceImpl() ;

    private  RefDataResponse refDataResponse ;
    private  RefDataResponse refDataResponse2 ;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        refDataResponse = new RefDataResponse();
        refDataResponse2 = new RefDataResponse();

        ReflectionTestUtils.setField(swiftRefService,"refDataUrl", "https://europa.swiftrefdata.com/v2/bics/" );
        ReflectionTestUtils.setField(swiftRefService, "refDataPwd", "cGF5dmFsQHN3aWZ0LmNvbV8xMjM0NTpaeXV1RnBiUFRiNFM0WXd5NE9tM2ZZbHlaMDh1NWlGcXptZ2FWcVZi");
    }
    @Test
    public void getSwiftRefData() {
        String xbic = "DEUTDEFFXXX";
        refDataResponse = swiftRefService.getSwiftRefData(xbic);
        Assert.assertNotNull(refDataResponse);
        Assert.assertEquals(16, refDataResponse.getNationalIds().size());
        Assert.assertNotNull(refDataResponse);


    }

    @Test
    public void parseSwiftRefRespID() {

        String xbic = "DEUTDEFFXXX";
        refDataResponse2 = swiftRefService.getSwiftRefData(xbic);
        List<String> swiftRefDataResponseList = swiftRefService.parseSwiftRefRespID(refDataResponse2);
        Assert.assertNotNull(swiftRefDataResponseList);
        Assert.assertEquals(16, swiftRefDataResponseList.size());
        Assert.assertEquals("50070010",swiftRefDataResponseList.get(0));

    }
}