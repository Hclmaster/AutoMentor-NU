package piazza;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "result",
        "error",
        "aid"
})
public class UserLoginResponse {

    @JsonProperty("result")
    private String result;
    @JsonProperty("error")
    private String error;
    @JsonProperty("aid")
    private String aid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("result")
    public String getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(String result) {
        this.result = result;
    }

    @JsonProperty("error")
    public Object getError() {
        return error;
    }

    @JsonProperty("error")
    public void setError(String error) {
        this.error = error;
    }

    @JsonProperty("aid")
    public String getAid() {
        return aid;
    }

    @JsonProperty("aid")
    public void setAid(String aid) {
        this.aid = aid;
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