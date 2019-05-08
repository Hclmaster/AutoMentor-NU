package piazza.responses.userStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "no_events"
})
public class Careers {

    @JsonProperty("no_events")
    private Boolean noEvents;

    @JsonProperty("no_events")
    public Boolean getNoEvents() {
        return noEvents;
    }

    @JsonProperty("no_events")
    public void setNoEvents(Boolean noEvents) {
        this.noEvents = noEvents;
    }

}
