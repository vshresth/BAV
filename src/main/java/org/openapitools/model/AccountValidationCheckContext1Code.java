package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
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

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static AccountValidationCheckContext1Code fromValue(String value) {
    for (AccountValidationCheckContext1Code b : AccountValidationCheckContext1Code.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

