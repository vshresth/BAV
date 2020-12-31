package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.model.OrganisationIdentificationSchemeName1Choice;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Information related to an identification of an organisation.
 */
@ApiModel(description = "Information related to an identification of an organisation.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-12-30T23:12:31.800-05:00[America/New_York]")
public class GenericOrganisationIdentification1  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("identification")
  private String identification;

  @JsonProperty("scheme_name")
  private OrganisationIdentificationSchemeName1Choice schemeName;

  @JsonProperty("issuer")
  private String issuer;

  public GenericOrganisationIdentification1 identification(String identification) {
    this.identification = identification;
    return this;
  }

  /**
   * Specifies a character string with a maximum length of 35 characters.
   * @return identification
  */
  @ApiModelProperty(required = true, value = "Specifies a character string with a maximum length of 35 characters.")
  @NotNull

@Size(min=1,max=35) 
  public String getIdentification() {
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
  */
  @ApiModelProperty(value = "")

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
   * Specifies a character string with a maximum length of 35 characters.
   * @return issuer
  */
  @ApiModelProperty(value = "Specifies a character string with a maximum length of 35 characters.")

@Size(min=1,max=35) 
  public String getIssuer() {
    return issuer;
  }

  public void setIssuer(String issuer) {
    this.issuer = issuer;
  }


  @Override
  public boolean equals(Object o) {
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

