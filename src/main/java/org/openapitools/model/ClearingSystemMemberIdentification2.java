package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.model.ClearingSystemIdentification2Choice;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Unique identification, as assigned by a clearing system, to unambiguously identify a member of the clearing system.
 */
@ApiModel(description = "Unique identification, as assigned by a clearing system, to unambiguously identify a member of the clearing system.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-12-30T23:12:31.800-05:00[America/New_York]")
public class ClearingSystemMemberIdentification2  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("clearing_system_identification")
  private ClearingSystemIdentification2Choice clearingSystemIdentification;

  @JsonProperty("member_identification")
  private String memberIdentification;

  public ClearingSystemMemberIdentification2 clearingSystemIdentification(ClearingSystemIdentification2Choice clearingSystemIdentification) {
    this.clearingSystemIdentification = clearingSystemIdentification;
    return this;
  }

  /**
   * Get clearingSystemIdentification
   * @return clearingSystemIdentification
  */
  @ApiModelProperty(value = "")

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
   * Specifies a character string with a maximum length of 35 characters.
   * @return memberIdentification
  */
  @ApiModelProperty(required = true, value = "Specifies a character string with a maximum length of 35 characters.")
  @NotNull

@Size(min=1,max=35) 
  public String getMemberIdentification() {
    return memberIdentification;
  }

  public void setMemberIdentification(String memberIdentification) {
    this.memberIdentification = memberIdentification;
  }


  @Override
  public boolean equals(Object o) {
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

