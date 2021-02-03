package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PhixiusResponse {

    @JsonProperty("name")
    private String name;
    @JsonProperty("job")
    private String job;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("createdAt")
    private String createdAt;



    @JsonProperty("account_validation_status")
    private AccountValidationResponse3Code accountValidationStatus = null;

    @JsonProperty("creditor_account_match")
    private AccountValidationResponse2Code creditorAccountMatch = null;

    @JsonProperty("creditor_name_match")
    private AccountValidationResponse1Code creditorNameMatch = null;

    @JsonProperty("creditor_address_match")
    private AccountValidationResponse1Code creditorAddressMatch = null;

    @JsonProperty("creditor_organisation_identification_match")
    private AccountValidationResponse1Code creditorOrganisationIdentificationMatch = null;

    @JsonProperty("correlation_identifier")
    private String correlationIdentifier = null;

    @JsonProperty("response")
    private ValidationCheckReponse1 response = null;

    public AccountValidationResponse3Code getAccountValidationStatus() {
        return AccountValidationResponse3Code.PASS;
    }

    public void setAccountValidationStatus(AccountValidationResponse3Code accountValidationStatus) {
        this.accountValidationStatus = accountValidationStatus;
    }

    public AccountValidationResponse2Code getCreditorAccountMatch() {
        return AccountValidationResponse2Code.NMTC;
    }

    public void setCreditorAccountMatch(AccountValidationResponse2Code creditorAccountMatch) {
        this.creditorAccountMatch = creditorAccountMatch;
    }

    public AccountValidationResponse1Code getCreditorNameMatch() {
        return AccountValidationResponse1Code.NOTC;
    }

    public void setCreditorNameMatch(AccountValidationResponse1Code creditorNameMatch) {
        this.creditorNameMatch = creditorNameMatch;
    }

    public AccountValidationResponse1Code getCreditorAddressMatch() {
        return AccountValidationResponse1Code.NOTC;
    }

    public void setCreditorAddressMatch(AccountValidationResponse1Code creditorAddressMatch) {
        this.creditorAddressMatch = creditorAddressMatch;
    }

    public AccountValidationResponse1Code getCreditorOrganisationIdentificationMatch() {
        return AccountValidationResponse1Code.NOTC;
    }

    public void setCreditorOrganisationIdentificationMatch(AccountValidationResponse1Code creditorOrganisationIdentificationMatch) {
        this.creditorOrganisationIdentificationMatch = creditorOrganisationIdentificationMatch;
    }

    public String getCorrelationIdentifier() {
        return "CORRID-003";
    }

    public void setCorrelationIdentifier(String correlationIdentifier) {
        this.correlationIdentifier = correlationIdentifier;
    }

    public ValidationCheckReponse1 getResponse() {
        return response;
    }

    public void setResponse(ValidationCheckReponse1 response) {
        this.response = response;
    }



    //for testing
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PhixiusResponse {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    job: ").append(toIndentedString(job)).append("\n");
        sb.append("}");
        return sb.toString();
    }
    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
