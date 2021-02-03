package io.swagger.utility;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

public  class AccountsApiHeaderExtract {

    public static HttpHeaders extractHeader(String xBic, String subjectDN, String institution, String accept){

        HttpHeaders headers = new HttpHeaders();
        headers.add("x-bic", xBic);
        headers.add("SubjectDN", subjectDN);
        headers.add("Institution", institution);
        headers.add("Accept", accept);

        return headers;
    }
}
