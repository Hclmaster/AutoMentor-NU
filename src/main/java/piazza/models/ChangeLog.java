package piazza.models;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "anon",
        "uid",
        "data",
        "type",
        "when"
})
public class ChangeLog {

    @JsonProperty("anon")
    private String anon;
    @JsonProperty("uid")
    private String uid;
    @JsonProperty("data")
    private String data;
    @JsonProperty("type")
    private String type;
    @JsonProperty("when")
    private String when;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("anon")
    public String getAnon() {
        return anon;
    }

    @JsonProperty("anon")
    public void setAnon(String anon) {
        this.anon = anon;
    }

    @JsonProperty("uid")
    public String getUid() {
        return uid;
    }

    @JsonProperty("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    @JsonProperty("data")
    public String getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(String data) {
        this.data = data;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("when")
    public String getWhen() {
        return when;
    }

    @JsonProperty("when")
    public void setWhen(String when) {
        this.when = when;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
