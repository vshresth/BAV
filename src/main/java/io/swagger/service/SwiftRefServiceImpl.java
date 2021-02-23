package io.swagger.service;

import io.swagger.Exception.CustomErrorException;
import io.swagger.model.RefDataResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class SwiftRefServiceImpl implements SwiftRefService {

    private static final Logger log = LoggerFactory.getLogger(SwiftRefServiceImpl.class);

    @Value("${refdata.url}")
    private String refDataUrl;
    @Value("${refdata.pwd}")
    private String refDataPwd;
    private final WebClient refWebClient;

    @Autowired
    public SwiftRefServiceImpl() {
        this.refWebClient = WebClient.builder().baseUrl(refDataUrl).defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
    }

    @Override
    @Cacheable(value = "swiftRefData")
    public RefDataResponse getSwiftRefData(String xbic) {
        log.info("in the getSwiftRefDataMethod");
        String swiftRefBasicAuth = "Basic " + refDataPwd;
        try {
            RefDataResponse refDataResponseNationalIds = refWebClient.get()
                    .uri(refDataUrl+ xbic + "/national_ids" )
                    .header("Authorization", swiftRefBasicAuth)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .onStatus(HttpStatus::is4xxClientError,
                            error -> Mono.error(new CustomErrorException("ClientResponse has erroneous status code: "+ error.statusCode() )))
                    .onStatus(HttpStatus::is5xxServerError,
                            error -> Mono.error(new CustomErrorException("Error with swiftRefServer: " + error.statusCode())))
                    .bodyToMono(RefDataResponse.class)
                    .block();

            log.info("return from getSwiftRefDataMethod");
            log.info("refID swiftRef webclient"+ refDataResponseNationalIds.toString());

            return refDataResponseNationalIds;
        } catch (Exception e) {
            log.error("error with swiftref " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<String> parseSwiftRefRespID(RefDataResponse refDataResponse){

        List<String> refDataNatlID = new ArrayList<>();
        log.info("refID swiftRef size " +refDataResponse.getNationalIds().size());
        try {
            if (refDataResponse != null && !refDataResponse.getNationalIds().isEmpty()) {
                for (RefDataResponse.NationalIds id : refDataResponse.getNationalIds()) {
                    refDataNatlID.add(id.getId());
                }
            }
        }
        catch (NullPointerException e){
            log.error("refdata is null,"+ e.getMessage());
        }
        log.info("refID swiftRef"+ refDataNatlID);

        return refDataNatlID;
    }

}
