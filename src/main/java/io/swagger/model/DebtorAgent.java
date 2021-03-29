package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DebtorAgent {

    @JsonProperty("memberIdentification")
    private String memberIdentification;

    @JsonProperty("clearingSystemIdentification")
    private String clearingSystemIdentification;

    public String getMemberIdentification() {
        return memberIdentification;
    }

    public void setMemberIdentification(String memberIdentification) {
        this.memberIdentification = memberIdentification;
    }

    public String getClearingSystemIdentification() {
        return clearingSystemIdentification;
    }

    public void setClearingSystemIdentification(String clearingSystemIdentification) {
        this.clearingSystemIdentification = clearingSystemIdentification;
    }
}
