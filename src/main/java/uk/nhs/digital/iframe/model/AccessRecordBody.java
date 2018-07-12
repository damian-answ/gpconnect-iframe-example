
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
    "clientId",
    "username",
    "clientCredentials",
    "patientDemographics",
    "token",
    "section",
    "startDate",
    "endDate"
})
public class AccessRecordBody {

    @JsonProperty("clientId")
    private String clientId;
    @JsonProperty("username")
    private String username;
    @JsonProperty("clientCredentials")
    private String clientCredentials;
    @JsonProperty("patientDemographics")
    private PatientDemographics patientDemographics;
    @JsonProperty("token")
    private String token;
    @JsonProperty("section")
    private String section;
    @JsonProperty("startDate")
    private String startDate;
    @JsonProperty("endDate")
    private String endDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("clientId")
    public String getClientId() {
        return clientId;
    }

    @JsonProperty("clientId")
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public AccessRecordBody withClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    public AccessRecordBody withUsername(String username) {
        this.username = username;
        return this;
    }

    @JsonProperty("clientCredentials")
    public String getClientCredentials() {
        return clientCredentials;
    }

    @JsonProperty("clientCredentials")
    public void setClientCredentials(String clientCredentials) {
        this.clientCredentials = clientCredentials;
    }

    public AccessRecordBody withClientCredentials(String clientCredentials) {
        this.clientCredentials = clientCredentials;
        return this;
    }

    @JsonProperty("patientDemographics")
    public PatientDemographics getPatientDemographics() {
        return patientDemographics;
    }

    @JsonProperty("patientDemographics")
    public void setPatientDemographics(PatientDemographics patientDemographics) {
        this.patientDemographics = patientDemographics;
    }

    public AccessRecordBody withPatientDemographics(PatientDemographics patientDemographics) {
        this.patientDemographics = patientDemographics;
        return this;
    }

    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    @JsonProperty("token")
    public void setToken(String token) {
        this.token = token;
    }

    public AccessRecordBody withToken(String token) {
        this.token = token;
        return this;
    }

    @JsonProperty("section")
    public String getSection() {
        return section;
    }

    @JsonProperty("section")
    public void setSection(String section) {
        this.section = section;
    }

    public AccessRecordBody withSection(String section) {
        this.section = section;
        return this;
    }

    @JsonProperty("startDate")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("startDate")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public AccessRecordBody withStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    @JsonProperty("endDate")
    public String getEndDate() {
        return endDate;
    }

    @JsonProperty("endDate")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public AccessRecordBody withEndDate(String endDate) {
        this.endDate = endDate;
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

    public AccessRecordBody withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
