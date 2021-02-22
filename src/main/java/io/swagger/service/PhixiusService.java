package io.swagger.service;

import io.swagger.model.PhixiusResponse;

public interface PhixiusService {

    public PhixiusResponse phixiusResponseCall(String memberIdentification);
}
