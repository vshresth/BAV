package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.AccountValidationCheckContext1Code;
import io.swagger.model.FinancialInstitutionIdentification20;
import io.swagger.model.OrganisationIdentification8;
import io.swagger.model.PostalAddress26;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Beneficiary account verification request.
 */
@Schema(description = "Beneficiary account verification request.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-12-31T21:15:33.955Z[GMT]")


public class AccountVerificationRequest   {
  @JsonProperty("correlation_identifier")
  private String correlationIdentifier = null;

  @JsonProperty("context")
  private AccountValidationCheckContext1Code context = null;

  @JsonProperty("uetr")
  private String uetr = null;

  @JsonProperty("creditor_account")
  private String creditorAccount = null;

  @JsonProperty("creditor_name")
  private String creditorName = null;

  @JsonProperty("creditor_address")
  private PostalAddress26 creditorAddress = null;

  @JsonProperty("creditor_organisation_identification")
  private OrganisationIdentification8 creditorOrganisationIdentification = null;

  @JsonProperty("creditor_agent")
  private FinancialInstitutionIdentification20 creditorAgent = null;

  @JsonProperty("creditor_agent_branch_identification")
  private String creditorAgentBranchIdentification = null;

  public AccountVerificationRequest correlationIdentifier(String correlationIdentifier) {
    this.correlationIdentifier = correlationIdentifier;
    return this;
  }

  /**
   * Get correlationIdentifier
   * @return correlationIdentifier
   **/
  @Schema(description = "")
  
  @Size(min=1,max=50)   public String getCorrelationIdentifier() {
    return correlationIdentifier;
  }

  public void setCorrelationIdentifier(String correlationIdentifier) {
    this.correlationIdentifier = correlationIdentifier;
  }

  public AccountVerificationRequest context(AccountValidationCheckContext1Code context) {
    this.context = context;
    return this;
  }

  /**
   * Get context
   * @return context
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public AccountValidationCheckContext1Code getContext() {
    return context;
  }

  public void setContext(AccountValidationCheckContext1Code context) {
    this.context = context;
  }

  public AccountVerificationRequest uetr(String uetr) {
    this.uetr = uetr;
    return this;
  }

  /**
   * Get uetr
   * @return uetr
   **/
  @Schema(description = "")
  
  @Pattern(regexp="^[a-f0-9]{8}-[a-f0-9]{4}-4[a-f0-9]{3}-[89ab][a-f0-9]{3}-[a-f0-9]{12}$")   public String getUetr() {
    return uetr;
  }

  public void setUetr(String uetr) {
    this.uetr = uetr;
  }

  public AccountVerificationRequest creditorAccount(String creditorAccount) {
    this.creditorAccount = creditorAccount;
    return this;
  }

  /**
   * Get creditorAccount
   * @return creditorAccount
   **/
  @Schema(required = true, description = "")
      @NotNull

  @Size(min=1,max=34)   public String getCreditorAccount() {
    return creditorAccount;
  }

  public void setCreditorAccount(String creditorAccount) {
    this.creditorAccount = creditorAccount;
  }

  public AccountVerificationRequest creditorName(String creditorName) {
    this.creditorName = creditorName;
    return this;
  }

  /**
   * Get creditorName
   * @return creditorName
   **/
  @Schema(required = true, description = "")
      @NotNull

  @Size(min=1,max=140)   public String getCreditorName() {
    return creditorName;
  }

  public void setCreditorName(String creditorName) {
    this.creditorName = creditorName;
  }

  public AccountVerificationRequest creditorAddress(PostalAddress26 creditorAddress) {
    this.creditorAddress = creditorAddress;
    return this;
  }

  /**
   * Get creditorAddress
   * @return creditorAddress
   **/
  @Schema(description = "")
  
    @Valid
    public PostalAddress26 getCreditorAddress() {
    return creditorAddress;
  }

  public void setCreditorAddress(PostalAddress26 creditorAddress) {
    this.creditorAddress = creditorAddress;
  }

  public AccountVerificationRequest creditorOrganisationIdentification(OrganisationIdentification8 creditorOrganisationIdentification) {
    this.creditorOrganisationIdentification = creditorOrganisationIdentification;
    return this;
  }

  /**
   * Get creditorOrganisationIdentification
   * @return creditorOrganisationIdentification
   **/
  @Schema(description = "")
  
    @Valid
    public OrganisationIdentification8 getCreditorOrganisationIdentification() {
    return creditorOrganisationIdentification;
  }

  public void setCreditorOrganisationIdentification(OrganisationIdentification8 creditorOrganisationIdentification) {
    this.creditorOrganisationIdentification = creditorOrganisationIdentification;
  }

  public AccountVerificationRequest creditorAgent(FinancialInstitutionIdentification20 creditorAgent) {
    this.creditorAgent = creditorAgent;
    return this;
  }

  /**
   * Get creditorAgent
   * @return creditorAgent
   **/
  @Schema(description = "")
  
    @Valid
    public FinancialInstitutionIdentification20 getCreditorAgent() {
    return creditorAgent;
  }

  public void setCreditorAgent(FinancialInstitutionIdentification20 creditorAgent) {
    this.creditorAgent = creditorAgent;
  }

  public AccountVerificationRequest creditorAgentBranchIdentification(String creditorAgentBranchIdentification) {
    this.creditorAgentBranchIdentification = creditorAgentBranchIdentification;
    return this;
  }

  /**
   * Get creditorAgentBranchIdentification
   * @return creditorAgentBranchIdentification
   **/
  @Schema(description = "")
  
  @Size(min=1,max=35)   public String getCreditorAgentBranchIdentification() {
    return creditorAgentBranchIdentification;
  }

  public void setCreditorAgentBranchIdentification(String creditorAgentBranchIdentification) {
    this.creditorAgentBranchIdentification = creditorAgentBranchIdentification;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountVerificationRequest accountVerificationRequest = (AccountVerificationRequest) o;
    return Objects.equals(this.correlationIdentifier, accountVerificationRequest.correlationIdentifier) &&
        Objects.equals(this.context, accountVerificationRequest.context) &&
        Objects.equals(this.uetr, accountVerificationRequest.uetr) &&
        Objects.equals(this.creditorAccount, accountVerificationRequest.creditorAccount) &&
        Objects.equals(this.creditorName, accountVerificationRequest.creditorName) &&
        Objects.equals(this.creditorAddress, accountVerificationRequest.creditorAddress) &&
        Objects.equals(this.creditorOrganisationIdentification, accountVerificationRequest.creditorOrganisationIdentification) &&
        Objects.equals(this.creditorAgent, accountVerificationRequest.creditorAgent) &&
        Objects.equals(this.creditorAgentBranchIdentification, accountVerificationRequest.creditorAgentBranchIdentification);
  }

  @Override
  public int hashCode() {
    return Objects.hash(correlationIdentifier, context, uetr, creditorAccount, creditorName, creditorAddress, creditorOrganisationIdentification, creditorAgent, creditorAgentBranchIdentification);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountVerificationRequest {\n");
    
    sb.append("    correlationIdentifier: ").append(toIndentedString(correlationIdentifier)).append("\n");
    sb.append("    context: ").append(toIndentedString(context)).append("\n");
    sb.append("    uetr: ").append(toIndentedString(uetr)).append("\n");
    sb.append("    creditorAccount: ").append(toIndentedString(creditorAccount)).append("\n");
    sb.append("    creditorName: ").append(toIndentedString(creditorName)).append("\n");
    sb.append("    creditorAddress: ").append(toIndentedString(creditorAddress)).append("\n");
    sb.append("    creditorOrganisationIdentification: ").append(toIndentedString(creditorOrganisationIdentification)).append("\n");
    sb.append("    creditorAgent: ").append(toIndentedString(creditorAgent)).append("\n");
    sb.append("    creditorAgentBranchIdentification: ").append(toIndentedString(creditorAgentBranchIdentification)).append("\n");
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
