package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.ClearingSystemIdentification2Choice;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Unique identification, as assigned by a clearing system, to unambiguously identify a member of the clearing system.
 */
@Schema(description = "Unique identification, as assigned by a clearing system, to unambiguously identify a member of the clearing system.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-12-31T21:15:33.955Z[GMT]")


public class ClearingSystemMemberIdentification2   {
  @JsonProperty("clearing_system_identification")
  private ClearingSystemIdentification2Choice clearingSystemIdentification = null;

  @JsonProperty("member_identification")
  private String memberIdentification = null;

  public ClearingSystemMemberIdentification2 clearingSystemIdentification(ClearingSystemIdentification2Choice clearingSystemIdentification) {
    this.clearingSystemIdentification = clearingSystemIdentification;
    return this;
  }

  /**
   * Get clearingSystemIdentification
   * @return clearingSystemIdentification
   **/
  @Schema(description = "")
  
    @Valid
    public ClearingSystemIdentification2Choice getClearingSystemIdentification() {
    return clearingSystemIdentification;
  }

  public void setClearingSystemIdentification(ClearingSystemIdentification2Choice clearingSystemIdentification) {
    this.clearingSystemIdentification = clearingSystemIdentification;
  }

  public ClearingSystemMemberIdentification2 memberIdentification(String memberIdentification) {
    this.memberIdentification = memberIdentification;
    return this;
  }

  /**
   * Get memberIdentification
   * @return memberIdentification
   **/
  @Schema(required = true, description = "")
      @NotNull

  @Size(min=1,max=35)   public String getMemberIdentification() {
    return memberIdentification;
  }

  public void setMemberIdentification(String memberIdentification) {
    this.memberIdentification = memberIdentification;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClearingSystemMemberIdentification2 clearingSystemMemberIdentification2 = (ClearingSystemMemberIdentification2) o;
    return Objects.equals(this.clearingSystemIdentification, clearingSystemMemberIdentification2.clearingSystemIdentification) &&
        Objects.equals(this.memberIdentification, clearingSystemMemberIdentification2.memberIdentification);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clearingSystemIdentification, memberIdentification);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClearingSystemMemberIdentification2 {\n");
    
    sb.append("    clearingSystemIdentification: ").append(toIndentedString(clearingSystemIdentification)).append("\n");
    sb.append("    memberIdentification: ").append(toIndentedString(memberIdentification)).append("\n");
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
