package piazza.responses.contentGet;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "is_announcement",
        "bypass_email"
})
public class Config {

    @JsonProperty("is_announcement")
    private Long isAnnouncement;
    @JsonProperty("bypass_email")
    private Long bypassEmail;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("is_announcement")
    public Long getIsAnnouncement() {
        return isAnnouncement;
    }

    @JsonProperty("is_announcement")
    public void setIsAnnouncement(Long isAnnouncement) {
        this.isAnnouncement = isAnnouncement;
    }

    @JsonProperty("bypass_email")
    public Long getBypassEmail() {
        return bypassEmail;
    }

    @JsonProperty("bypass_email")
    public void setBypassEmail(Long bypassEmail) {
        this.bypassEmail = bypassEmail;
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
