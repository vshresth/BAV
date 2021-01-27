package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Choice of a clearing system identifier.
 */
@Schema(description = "Choice of a clearing system identifier.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-12-31T21:15:33.955Z[GMT]")


public class ClearingSystemIdentification2Choice   {
  @JsonProperty("code")
  private String code = null;

  @JsonProperty("proprietary")
  private String proprietary = null;

  public ClearingSystemIdentification2Choice code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
   **/
  @Schema(description = "")
  
    public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public ClearingSystemIdentification2Choice proprietary(String proprietary) {
    this.proprietary = proprietary;
    return this;
  }

  /**
   * Get proprietary
   * @return proprietary
   **/
  @Schema(description = "")
  
  @Size(min=1,max=35)   public String getProprietary() {
    return proprietary;
  }

  public void setProprietary(String proprietary) {
    this.proprietary = proprietary;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClearingSystemIdentification2Choice clearingSystemIdentification2Choice = (ClearingSystemIdentification2Choice) o;
    return Objects.equals(this.code, clearingSystemIdentification2Choice.code) &&
        Objects.equals(this.proprietary, clearingSystemIdentification2Choice.proprietary);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, proprietary);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClearingSystemIdentification2Choice {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    proprietary: ").append(toIndentedString(proprietary)).append("\n");
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
