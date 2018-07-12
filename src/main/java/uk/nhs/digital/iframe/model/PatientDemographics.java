
package uk.nhs.digital.iframe.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "familyName",
    "givenName",
    "gender",
    "birthDate",
    "nhsNumber",
    "odsCode"
})
public class PatientDemographics {

    @JsonProperty("familyName")
    private String familyName;
    @JsonProperty("givenName")
    private String givenName;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("birthDate")
    private String birthDate;
    @JsonProperty("nhsNumber")
    private String nhsNumber;
    @JsonProperty("odsCode")
    private String odsCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("familyName")
    public String getFamilyName() {
        return familyName;
    }

    @JsonProperty("familyName")
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public PatientDemographics withFamilyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    @JsonProperty("givenName")
    public String getGivenName() {
        return givenName;
    }

    @JsonProperty("givenName")
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public PatientDemographics withGivenName(String givenName) {
        this.givenName = givenName;
        return this;
    }

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    public PatientDemographics withGender(String gender) {
        this.gender = gender;
        return this;
    }

    @JsonProperty("birthDate")
    public String getBirthDate() {
        return birthDate;
    }

    @JsonProperty("birthDate")
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public PatientDemographics withBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    @JsonProperty("nhsNumber")
    public String getNhsNumber() {
        return nhsNumber;
    }

    @JsonProperty("nhsNumber")
    public void setNhsNumber(String nhsNumber) {
        this.nhsNumber = nhsNumber;
    }

    public PatientDemographics withNhsNumber(String nhsNumber) {
        this.nhsNumber = nhsNumber;
        return this;
    }

    @JsonProperty("odsCode")
    public String getOdsCode() {
        return odsCode;
    }

    @JsonProperty("odsCode")
    public void setOdsCode(String odsCode) {
        this.odsCode = odsCode;
    }

    public PatientDemographics withOdsCode(String odsCode) {
        this.odsCode = odsCode;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public PatientDemographics withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
