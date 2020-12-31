package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Sets of elements to identify a name of the organisation identification scheme.
 */
@ApiModel(description = "Sets of elements to identify a name of the organisation identification scheme.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-12-30T23:12:31.800-05:00[America/New_York]")
public class OrganisationIdentificationSchemeName1Choice  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("code")
  private String code;

  @JsonProperty("proprietary")
  private String proprietary;

  public OrganisationIdentificationSchemeName1Choice code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Specifies the external organisation identification scheme name code in the format of character string with a maximum length of 4 characters.  The list of valid codes is an external code list published separately.  External code sets can be downloaded from www.iso20022.org.
   * @return code
  */
  @ApiModelProperty(value = "Specifies the external organisation identification scheme name code in the format of character string with a maximum length of 4 characters.  The list of valid codes is an external code list published separately.  External code sets can be downloaded from www.iso20022.org.")


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public OrganisationIdentificationSchemeName1Choice proprietary(String proprietary) {
    this.proprietary = proprietary;
    return this;
  }

  /**
   * Specifies a character string with a maximum length of 35 characters.
   * @return proprietary
  */
  @ApiModelProperty(value = "Specifies a character string with a maximum length of 35 characters.")

@Size(min=1,max=35) 
  public String getProprietary() {
    return proprietary;
  }

  public void setProprietary(String proprietary) {
    this.proprietary = proprietary;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganisationIdentificationSchemeName1Choice organisationIdentificationSchemeName1Choice = (OrganisationIdentificationSchemeName1Choice) o;
    return Objects.equals(this.code, organisationIdentificationSchemeName1Choice.code) &&
        Objects.equals(this.proprietary, organisationIdentificationSchemeName1Choice.proprietary);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, proprietary);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganisationIdentificationSchemeName1Choice {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    proprietary: ").append(toIndentedString(proprietary)).append("\n");
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

