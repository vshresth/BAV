package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.AccountValidationResponse1Code;
import io.swagger.model.AccountValidationResponse2Code;
import io.swagger.model.AccountValidationResponse3Code;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ValidationCheckReponse1
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-12-31T21:15:33.955Z[GMT]")

@Component("validationCheckReponse1")
public class ValidationCheckReponse1   {
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

  public ValidationCheckReponse1 accountValidationStatus(AccountValidationResponse3Code accountValidationStatus) {
    this.accountValidationStatus = accountValidationStatus;
    return this;
  }

  /**
   * Get accountValidationStatus
   * @return accountValidationStatus
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public AccountValidationResponse3Code getAccountValidationStatus() {
    return accountValidationStatus;
  }

  public void setAccountValidationStatus(AccountValidationResponse3Code accountValidationStatus) {
    this.accountValidationStatus = accountValidationStatus;
  }

  public ValidationCheckReponse1 creditorAccountMatch(AccountValidationResponse2Code creditorAccountMatch) {
    this.creditorAccountMatch = creditorAccountMatch;
    return this;
  }

  /**
   * Get creditorAccountMatch
   * @return creditorAccountMatch
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public AccountValidationResponse2Code getCreditorAccountMatch() {
    return creditorAccountMatch;
  }

  public void setCreditorAccountMatch(AccountValidationResponse2Code creditorAccountMatch) {
    this.creditorAccountMatch = creditorAccountMatch;
  }

  public ValidationCheckReponse1 creditorNameMatch(AccountValidationResponse1Code creditorNameMatch) {
    this.creditorNameMatch = creditorNameMatch;
    return this;
  }

  /**
   * Get creditorNameMatch
   * @return creditorNameMatch
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public AccountValidationResponse1Code getCreditorNameMatch() {
    return creditorNameMatch;
  }

  public void setCreditorNameMatch(AccountValidationResponse1Code creditorNameMatch) {
    this.creditorNameMatch = creditorNameMatch;
  }

  public ValidationCheckReponse1 creditorAddressMatch(AccountValidationResponse1Code creditorAddressMatch) {
    this.creditorAddressMatch = creditorAddressMatch;
    return this;
  }

  /**
   * Get creditorAddressMatch
   * @return creditorAddressMatch
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public AccountValidationResponse1Code getCreditorAddressMatch() {
    return creditorAddressMatch;
  }

  public void setCreditorAddressMatch(AccountValidationResponse1Code creditorAddressMatch) {
    this.creditorAddressMatch = creditorAddressMatch;
  }

  public ValidationCheckReponse1 creditorOrganisationIdentificationMatch(AccountValidationResponse1Code creditorOrganisationIdentificationMatch) {
    this.creditorOrganisationIdentificationMatch = creditorOrganisationIdentificationMatch;
    return this;
  }

  /**
   * Get creditorOrganisationIdentificationMatch
   * @return creditorOrganisationIdentificationMatch
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public AccountValidationResponse1Code getCreditorOrganisationIdentificationMatch() {
    return creditorOrganisationIdentificationMatch;
  }

  public void setCreditorOrganisationIdentificationMatch(AccountValidationResponse1Code creditorOrganisationIdentificationMatch) {
    this.creditorOrganisationIdentificationMatch = creditorOrganisationIdentificationMatch;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ValidationCheckReponse1 validationCheckReponse1 = (ValidationCheckReponse1) o;
    return Objects.equals(this.accountValidationStatus, validationCheckReponse1.accountValidationStatus) &&
        Objects.equals(this.creditorAccountMatch, validationCheckReponse1.creditorAccountMatch) &&
        Objects.equals(this.creditorNameMatch, validationCheckReponse1.creditorNameMatch) &&
        Objects.equals(this.creditorAddressMatch, validationCheckReponse1.creditorAddressMatch) &&
        Objects.equals(this.creditorOrganisationIdentificationMatch, validationCheckReponse1.creditorOrganisationIdentificationMatch);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountValidationStatus, creditorAccountMatch, creditorNameMatch, creditorAddressMatch, creditorOrganisationIdentificationMatch);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValidationCheckReponse1 {\n");
    
    sb.append("    accountValidationStatus: ").append(toIndentedString(accountValidationStatus)).append("\n");
    sb.append("    creditorAccountMatch: ").append(toIndentedString(creditorAccountMatch)).append("\n");
    sb.append("    creditorNameMatch: ").append(toIndentedString(creditorNameMatch)).append("\n");
    sb.append("    creditorAddressMatch: ").append(toIndentedString(creditorAddressMatch)).append("\n");
    sb.append("    creditorOrganisationIdentificationMatch: ").append(toIndentedString(creditorOrganisationIdentificationMatch)).append("\n");
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
