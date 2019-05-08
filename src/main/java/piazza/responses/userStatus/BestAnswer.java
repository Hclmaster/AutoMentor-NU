package piazza.responses.userStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "uid",
        "nr",
        "time",
        "text",
        "when"
})
public class BestAnswer {

    @JsonProperty("uid")
    private Object uid;
    @JsonProperty("nr")
    private Long nr;
    @JsonProperty("time")
    private Long time;
    @JsonProperty("text")
    private String text;
    @JsonProperty("when")
    private Long when;

    @JsonProperty("uid")
    public Object getUid() {
        return uid;
    }

    @JsonProperty("uid")
    public void setUid(Object uid) {
        this.uid = uid;
    }

    @JsonProperty("nr")
    public Long getNr() {
        return nr;
    }

    @JsonProperty("nr")
    public void setNr(Long nr) {
        this.nr = nr;
    }

    @JsonProperty("time")
    public Long getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(Long time) {
        this.time = time;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("when")
    public Long getWhen() {
        return when;
    }

    @JsonProperty("when")
    public void setWhen(Long when) {
        this.when = when;
    }

}
