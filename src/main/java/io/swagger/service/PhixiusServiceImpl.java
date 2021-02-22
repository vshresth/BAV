package io.swagger.service;

import io.swagger.model.DebtorAccount;
import io.swagger.model.DebtorAgent;
import io.swagger.model.PhixiusRequest;
import io.swagger.model.PhixiusResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PhixiusServiceImpl  implements PhixiusService{

    private static final Logger log = LoggerFactory.getLogger(PhixiusServiceImpl.class);


    @Value("${test.url}")
    private String testUrl;


    @Autowired
    PhixiusRequest phixiusRequest;
    private final WebClient webClient;

    @Autowired
    public PhixiusServiceImpl() {
        log.info("End URL is: " + testUrl);
        this.webClient = WebClient.builder().baseUrl(testUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                .build();
        log.info("in const 1:");
    }

    @Override
    public PhixiusResponse phixiusResponseCall(String memberIdentification){
//          phixiusRequest  = new PhixiusRequest();
//        PhixiusResponse phixiusResponse = webClient.post()
//                .uri(testUrl)
//                .header("x-bic", xbic)
//                .header("SubjectDN", subDn)
//                .header("Institution", inst)
//                .header("Authorization", basicAuth)
//                .header("Accept", "application/json")
//                .body(Mono.just(phixiusRequest), PhixiusRequest.class)
//                .retrieve()
//                .bodyToMono(PhixiusResponse.class)
//                .block();

        PhixiusResponse phixiusResponse = new PhixiusResponse();

        phixiusResponse.setAccountStatus("Enabled");
        DebtorAccount debtorAccount = new DebtorAccount();
        debtorAccount.setIdentification("13590100098332");

        DebtorAgent debtorAgent = new DebtorAgent();
        debtorAgent.setMemberIdentification("22607803");
        debtorAgent.setClearingSystemIdentification("USABA");

        // phixiusResponse.setDebtorAccount();
        phixiusResponse.setDebtorAccount(debtorAccount);
        phixiusResponse.setDebtorAgent(debtorAgent);
        return phixiusResponse;
    }
}
