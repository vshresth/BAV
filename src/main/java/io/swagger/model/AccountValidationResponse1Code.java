package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets AccountValidationResponse1Code
 */
public enum AccountValidationResponse1Code {
  NOTC("NOTC"),
    NOAP("NOAP"),
    NMTC("NMTC"),
    MTCH("MTCH");

  private String value;

  AccountValidationResponse1Code(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static AccountValidationResponse1Code fromValue(String text) {
    for (AccountValidationResponse1Code b : AccountValidationResponse1Code.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
