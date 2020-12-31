package org.openapitools.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-12-30T23:12:31.800-05:00[America/New_York]")
@Controller
@RequestMapping("${openapi.beneficiaryAccountPreValidationProviderAPI.base-path:/v1}")
public class AccountsApiController implements AccountsApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public AccountsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
