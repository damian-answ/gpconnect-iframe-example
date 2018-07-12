
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
    "alg",
    "typ",
    "Authorisation"
})
public class AccessRecordHeader {

    @JsonProperty("alg")
    private String alg;
    @JsonProperty("typ")
    private String typ;
    @JsonProperty("Authorisation")
    private String authorisation;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("alg")
    public String getAlg() {
        return alg;
    }

    @JsonProperty("alg")
    public void setAlg(String alg) {
        this.alg = alg;
    }

    public AccessRecordHeader withAlg(String alg) {
        this.alg = alg;
        return this;
    }

    @JsonProperty("typ")
    public String getTyp() {
        return typ;
    }

    @JsonProperty("typ")
    public void setTyp(String typ) {
        this.typ = typ;
    }

    public AccessRecordHeader withTyp(String typ) {
        this.typ = typ;
        return this;
    }

    @JsonProperty("Authorisation")
    public String getAuthorisation() {
        return authorisation;
    }

    @JsonProperty("Authorisation")
    public void setAuthorisation(String authorisation) {
        this.authorisation = authorisation;
    }

    public AccessRecordHeader withAuthorisation(String authorisation) {
        this.authorisation = authorisation;
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

    public AccessRecordHeader withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
