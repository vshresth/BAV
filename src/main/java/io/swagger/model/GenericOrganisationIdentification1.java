package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.OrganisationIdentificationSchemeName1Choice;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Information related to an identification of an organisation.
 */
@Schema(description = "Information related to an identification of an organisation.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-12-31T21:15:33.955Z[GMT]")


public class GenericOrganisationIdentification1   {
  @JsonProperty("identification")
  private String identification = null;

  @JsonProperty("scheme_name")
  private OrganisationIdentificationSchemeName1Choice schemeName = null;

  @JsonProperty("issuer")
  private String issuer = null;

  public GenericOrganisationIdentification1 identification(String identification) {
    this.identification = identification;
    return this;
  }

  /**
   * Get identification
   * @return identification
   **/
  @Schema(required = true, description = "")
      @NotNull

  @Size(min=1,max=35)   public String getIdentification() {
    return identification;
  }

  public void setIdentification(String identification) {
    this.identification = identification;
  }

  public GenericOrganisationIdentification1 schemeName(OrganisationIdentificationSchemeName1Choice schemeName) {
    this.schemeName = schemeName;
    return this;
  }

  /**
   * Get schemeName
   * @return schemeName
   **/
  @Schema(description = "")
  
    @Valid
    public OrganisationIdentificationSchemeName1Choice getSchemeName() {
    return schemeName;
  }

  public void setSchemeName(OrganisationIdentificationSchemeName1Choice schemeName) {
    this.schemeName = schemeName;
  }

  public GenericOrganisationIdentification1 issuer(String issuer) {
    this.issuer = issuer;
    return this;
  }

  /**
   * Get issuer
   * @return issuer
   **/
  @Schema(description = "")
  
  @Size(min=1,max=35)   public String getIssuer() {
    return issuer;
  }

  public void setIssuer(String issuer) {
    this.issuer = issuer;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GenericOrganisationIdentification1 genericOrganisationIdentification1 = (GenericOrganisationIdentification1) o;
    return Objects.equals(this.identification, genericOrganisationIdentification1.identification) &&
        Objects.equals(this.schemeName, genericOrganisationIdentification1.schemeName) &&
        Objects.equals(this.issuer, genericOrganisationIdentification1.issuer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identification, schemeName, issuer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GenericOrganisationIdentification1 {\n");
    
    sb.append("    identification: ").append(toIndentedString(identification)).append("\n");
    sb.append("    schemeName: ").append(toIndentedString(schemeName)).append("\n");
    sb.append("    issuer: ").append(toIndentedString(issuer)).append("\n");
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
