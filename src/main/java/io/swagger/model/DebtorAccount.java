package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DebtorAccount {

    @JsonProperty("identification")
    private String identification;

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }
}
