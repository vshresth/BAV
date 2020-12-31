package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.model.ValidationCheckReponse1;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Beneficiary account verification response.
 */
@ApiModel(description = "Beneficiary account verification response.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-12-30T23:12:31.800-05:00[America/New_York]")
public class AccountVerificationResponse1  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("correlation_identifier")
  private String correlationIdentifier;

  @JsonProperty("response")
  private ValidationCheckReponse1 response;

  public AccountVerificationResponse1 correlationIdentifier(String correlationIdentifier) {
    this.correlationIdentifier = correlationIdentifier;
    return this;
  }

  /**
   * Specifies a character string with a maximum length of 50 characters.
   * @return correlationIdentifier
  */
  @ApiModelProperty(value = "Specifies a character string with a maximum length of 50 characters.")

@Size(min=1,max=50) 
  public String getCorrelationIdentifier() {
    return correlationIdentifier;
  }

  public void setCorrelationIdentifier(String correlationIdentifier) {
    this.correlationIdentifier = correlationIdentifier;
  }

  public AccountVerificationResponse1 response(ValidationCheckReponse1 response) {
    this.response = response;
    return this;
  }

  /**
   * Get response
   * @return response
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public ValidationCheckReponse1 getResponse() {
    return response;
  }

  public void setResponse(ValidationCheckReponse1 response) {
    this.response = response;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountVerificationResponse1 accountVerificationResponse1 = (AccountVerificationResponse1) o;
    return Objects.equals(this.correlationIdentifier, accountVerificationResponse1.correlationIdentifier) &&
        Objects.equals(this.response, accountVerificationResponse1.response);
  }

  @Override
  public int hashCode() {
    return Objects.hash(correlationIdentifier, response);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountVerificationResponse1 {\n");
    
    sb.append("    correlationIdentifier: ").append(toIndentedString(correlationIdentifier)).append("\n");
    sb.append("    response: ").append(toIndentedString(response)).append("\n");
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

