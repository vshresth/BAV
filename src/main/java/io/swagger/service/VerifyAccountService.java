package io.swagger.service;

import io.swagger.model.AccountVerificationRequest;
import io.swagger.model.AccountVerificationResponse1;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface VerifyAccountService {

    public List<AccountVerificationResponse1> verifyAccountService(String xBic, String subjectDN, String institution, AccountVerificationResponse1 accountVerificationResponse1);

}
