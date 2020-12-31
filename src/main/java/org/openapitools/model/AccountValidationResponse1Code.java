package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
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

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static AccountValidationResponse1Code fromValue(String value) {
    for (AccountValidationResponse1Code b : AccountValidationResponse1Code.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

