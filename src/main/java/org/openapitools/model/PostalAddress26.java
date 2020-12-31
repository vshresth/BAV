package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Information that locates and identifies a specific address, as defined by postal services.
 */
@ApiModel(description = "Information that locates and identifies a specific address, as defined by postal services.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-12-30T23:12:31.800-05:00[America/New_York]")
public class PostalAddress26  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("country")
  private String country;

  @JsonProperty("address_line")
  @Valid
  private List<String> addressLine = null;

  @JsonProperty("post_code")
  private String postCode;

  @JsonProperty("town_name")
  private String townName;

  public PostalAddress26 country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Code to identify a country, a dependency, or another area of particular geopolitical interest, on the basis of country names obtained from the United Nations (ISO 3166, Alpha-2 code).
   * @return country
  */
  @ApiModelProperty(value = "Code to identify a country, a dependency, or another area of particular geopolitical interest, on the basis of country names obtained from the United Nations (ISO 3166, Alpha-2 code).")

@Pattern(regexp="^[A-Z]{2,2}$") 
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public PostalAddress26 addressLine(List<String> addressLine) {
    this.addressLine = addressLine;
    return this;
  }

  public PostalAddress26 addAddressLineItem(String addressLineItem) {
    if (this.addressLine == null) {
      this.addressLine = new ArrayList<>();
    }
    this.addressLine.add(addressLineItem);
    return this;
  }

  /**
   * Information that locates and identifies a specific address, as defined by postal services, presented in free format text.
   * @return addressLine
  */
  @ApiModelProperty(value = "Information that locates and identifies a specific address, as defined by postal services, presented in free format text.")

@Size(max=7) 
  public List<String> getAddressLine() {
    return addressLine;
  }

  public void setAddressLine(List<String> addressLine) {
    this.addressLine = addressLine;
  }

  public PostalAddress26 postCode(String postCode) {
    this.postCode = postCode;
    return this;
  }

  /**
   * Specifies a character string with a maximum length of 16 characters.
   * @return postCode
  */
  @ApiModelProperty(value = "Specifies a character string with a maximum length of 16 characters.")

@Size(min=1,max=16) 
  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }

  public PostalAddress26 townName(String townName) {
    this.townName = townName;
    return this;
  }

  /**
   * Specifies a character string with a maximum length of 35 characters.
   * @return townName
  */
  @ApiModelProperty(value = "Specifies a character string with a maximum length of 35 characters.")

@Size(min=1,max=35) 
  public String getTownName() {
    return townName;
  }

  public void setTownName(String townName) {
    this.townName = townName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostalAddress26 postalAddress26 = (PostalAddress26) o;
    return Objects.equals(this.country, postalAddress26.country) &&
        Objects.equals(this.addressLine, postalAddress26.addressLine) &&
        Objects.equals(this.postCode, postalAddress26.postCode) &&
        Objects.equals(this.townName, postalAddress26.townName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(country, addressLine, postCode, townName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostalAddress26 {\n");
    
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    addressLine: ").append(toIndentedString(addressLine)).append("\n");
    sb.append("    postCode: ").append(toIndentedString(postCode)).append("\n");
    sb.append("    townName: ").append(toIndentedString(townName)).append("\n");
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

