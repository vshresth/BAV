package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.model.ClearingSystemMemberIdentification2;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Set of elements used to identify a financial institution.
 */
@ApiModel(description = "Set of elements used to identify a financial institution.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-12-30T23:12:31.800-05:00[America/New_York]")
public class FinancialInstitutionIdentification20  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("bicfi")
  private String bicfi;

  @JsonProperty("clearing_system_member_identification")
  private ClearingSystemMemberIdentification2 clearingSystemMemberIdentification;

  public FinancialInstitutionIdentification20 bicfi(String bicfi) {
    this.bicfi = bicfi;
    return this;
  }

  /**
   * Code allocated to a financial institution by the ISO 9362 Registration Authority as described in ISO 9362 \"Banking - Banking telecommunication messages - Business identifier code (BIC)\".
   * @return bicfi
  */
  @ApiModelProperty(value = "Code allocated to a financial institution by the ISO 9362 Registration Authority as described in ISO 9362 \"Banking - Banking telecommunication messages - Business identifier code (BIC)\".")

@Pattern(regexp="^[A-Z]{6,6}[A-Z2-9][A-NP-Z0-9]([A-Z0-9]{3,3}){0,1}$") 
  public String getBicfi() {
    return bicfi;
  }

  public void setBicfi(String bicfi) {
    this.bicfi = bicfi;
  }

  public FinancialInstitutionIdentification20 clearingSystemMemberIdentification(ClearingSystemMemberIdentification2 clearingSystemMemberIdentification) {
    this.clearingSystemMemberIdentification = clearingSystemMemberIdentification;
    return this;
  }

  /**
   * Get clearingSystemMemberIdentification
   * @return clearingSystemMemberIdentification
  */
  @ApiModelProperty(value = "")

  @Valid

  public ClearingSystemMemberIdentification2 getClearingSystemMemberIdentification() {
    return clearingSystemMemberIdentification;
  }

  public void setClearingSystemMemberIdentification(ClearingSystemMemberIdentification2 clearingSystemMemberIdentification) {
    this.clearingSystemMemberIdentification = clearingSystemMemberIdentification;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FinancialInstitutionIdentification20 financialInstitutionIdentification20 = (FinancialInstitutionIdentification20) o;
    return Objects.equals(this.bicfi, financialInstitutionIdentification20.bicfi) &&
        Objects.equals(this.clearingSystemMemberIdentification, financialInstitutionIdentification20.clearingSystemMemberIdentification);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bicfi, clearingSystemMemberIdentification);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FinancialInstitutionIdentification20 {\n");
    
    sb.append("    bicfi: ").append(toIndentedString(bicfi)).append("\n");
    sb.append("    clearingSystemMemberIdentification: ").append(toIndentedString(clearingSystemMemberIdentification)).append("\n");
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

