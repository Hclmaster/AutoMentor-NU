package piazza.responses.userStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "when",
        "state"
})
public class FeedDigest {

    @JsonProperty("when")
    private Long when;
    @JsonProperty("state")
    private String state;

    @JsonProperty("when")
    public Long getWhen() {
        return when;
    }

    @JsonProperty("when")
    public void setWhen(Long when) {
        this.when = when;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

}
