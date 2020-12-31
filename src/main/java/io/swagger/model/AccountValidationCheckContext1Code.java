package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets AccountValidationCheckContext1Code
 */
public enum AccountValidationCheckContext1Code {
  BENR("BENR"),
    PAYM("PAYM"),
    RFPP("RFPP");

  private String value;

  AccountValidationCheckContext1Code(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static AccountValidationCheckContext1Code fromValue(String text) {
    for (AccountValidationCheckContext1Code b : AccountValidationCheckContext1Code.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
