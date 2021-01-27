package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Information that locates and identifies a specific address, as defined by postal services.
 */
@Schema(description = "Information that locates and identifies a specific address, as defined by postal services.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-12-31T21:15:33.955Z[GMT]")


public class PostalAddress26   {
  @JsonProperty("country")
  private String country = null;

  @JsonProperty("address_line")
  @Valid
  private List<String> addressLine = null;

  @JsonProperty("post_code")
  private String postCode = null;

  @JsonProperty("town_name")
  private String townName = null;

  public PostalAddress26 country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Get country
   * @return country
   **/
  @Schema(description = "")
  
  @Pattern(regexp="^[A-Z]{2,2}$")   public String getCountry() {
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
      this.addressLine = new ArrayList<String>();
    }
    this.addressLine.add(addressLineItem);
    return this;
  }

  /**
   * Information that locates and identifies a specific address, as defined by postal services, presented in free format text.
   * @return addressLine
   **/
  @Schema(description = "Information that locates and identifies a specific address, as defined by postal services, presented in free format text.")
  
  @Size(max=7)   public List<String> getAddressLine() {
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
   * Get postCode
   * @return postCode
   **/
  @Schema(description = "")
  
  @Size(min=1,max=16)   public String getPostCode() {
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
   * Get townName
   * @return townName
   **/
  @Schema(description = "")
  
  @Size(min=1,max=35)   public String getTownName() {
    return townName;
  }

  public void setTownName(String townName) {
    this.townName = townName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
