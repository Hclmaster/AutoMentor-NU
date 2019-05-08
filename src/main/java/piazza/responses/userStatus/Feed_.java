package piazza.responses.userStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "following",
        "updated",
        "unread",
        "unresolved"
})
public class Feed_ {

    @JsonProperty("following")
    private Long following;
    @JsonProperty("updated")
    private Long updated;
    @JsonProperty("unread")
    private Long unread;
    @JsonProperty("unresolved")
    private Long unresolved;

    @JsonProperty("following")
    public Long getFollowing() {
        return following;
    }

    @JsonProperty("following")
    public void setFollowing(Long following) {
        this.following = following;
    }

    @JsonProperty("updated")
    public Long getUpdated() {
        return updated;
    }

    @JsonProperty("updated")
    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    @JsonProperty("unread")
    public Long getUnread() {
        return unread;
    }

    @JsonProperty("unread")
    public void setUnread(Long unread) {
        this.unread = unread;
    }

    @JsonProperty("unresolved")
    public Long getUnresolved() {
        return unresolved;
    }

    @JsonProperty("unresolved")
    public void setUnresolved(Long unresolved) {
        this.unresolved = unresolved;
    }

}
