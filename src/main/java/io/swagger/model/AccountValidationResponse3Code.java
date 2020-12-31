package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets AccountValidationResponse3Code
 */
public enum AccountValidationResponse3Code {
  PASS("PASS"),
    INCO("INCO"),
    FAIL("FAIL");

  private String value;

  AccountValidationResponse3Code(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static AccountValidationResponse3Code fromValue(String text) {
    for (AccountValidationResponse3Code b : AccountValidationResponse3Code.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
