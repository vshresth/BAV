package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets AccountValidationResponse2Code
 */
public enum AccountValidationResponse2Code {
  NMTC("NMTC"),
    MTCH("MTCH");

  private String value;

  AccountValidationResponse2Code(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static AccountValidationResponse2Code fromValue(String text) {
    for (AccountValidationResponse2Code b : AccountValidationResponse2Code.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
