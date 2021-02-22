package io.swagger.service;

import io.swagger.model.RefDataResponse;
import java.util.List;

public interface SwiftRefService {

    public RefDataResponse getSwiftRefData(String xbic);
    public List<String>  parseSwiftRefRespID(RefDataResponse refDataResponse);
}
