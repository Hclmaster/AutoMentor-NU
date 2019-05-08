package piazza.responses.userStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "channel_ids",
        "signature",
        "timestamp"
})
public class TokenData {

    @JsonProperty("channel_ids")
    private List<String> channelIds = null;
    @JsonProperty("signature")
    private String signature;
    @JsonProperty("timestamp")
    private Long timestamp;

    @JsonProperty("channel_ids")
    public List<String> getChannelIds() {
        return channelIds;
    }

    @JsonProperty("channel_ids")
    public void setChannelIds(List<String> channelIds) {
        this.channelIds = channelIds;
    }

    @JsonProperty("signature")
    public String getSignature() {
        return signature;
    }

    @JsonProperty("signature")
    public void setSignature(String signature) {
        this.signature = signature;
    }

    @JsonProperty("timestamp")
    public Long getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

}
