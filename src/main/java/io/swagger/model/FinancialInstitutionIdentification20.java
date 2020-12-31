package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.ClearingSystemMemberIdentification2;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Set of elements used to identify a financial institution.
 */
@Schema(description = "Set of elements used to identify a financial institution.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-12-31T21:15:33.955Z[GMT]")


public class FinancialInstitutionIdentification20   {
  @JsonProperty("bicfi")
  private String bicfi = null;

  @JsonProperty("clearing_system_member_identification")
  private ClearingSystemMemberIdentification2 clearingSystemMemberIdentification = null;

  public FinancialInstitutionIdentification20 bicfi(String bicfi) {
    this.bicfi = bicfi;
    return this;
  }

  /**
   * Get bicfi
   * @return bicfi
   **/
  @Schema(description = "")
  
  @Pattern(regexp="^[A-Z]{6,6}[A-Z2-9][A-NP-Z0-9]([A-Z0-9]{3,3}){0,1}$")   public String getBicfi() {
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
   **/
  @Schema(description = "")
  
    @Valid
    public ClearingSystemMemberIdentification2 getClearingSystemMemberIdentification() {
    return clearingSystemMemberIdentification;
  }

  public void setClearingSystemMemberIdentification(ClearingSystemMemberIdentification2 clearingSystemMemberIdentification) {
    this.clearingSystemMemberIdentification = clearingSystemMemberIdentification;
  }


  @Override
  public boolean equals(java.lang.Object o) {
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
