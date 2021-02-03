package io.swagger.service;

import io.swagger.model.AccountVerificationRequest;
import io.swagger.model.AccountVerificationResponse1;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface VerifyAccountService {

    public AccountVerificationResponse1 verifyAccountService(AccountVerificationRequest body);
    public AccountVerificationResponse1 verifyAccountService(AccountVerificationRequest body, HttpHeaders headers);
    public AccountVerificationResponse1 verifyAccountService(AccountVerificationRequest body, String xbic, String subDN, String inst);

}
