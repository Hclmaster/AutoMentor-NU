package piazza.responses.userStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "result",
        "error",
        "aid"
})
public class UserStatusResponse {

    @JsonProperty("result")
    private Result result;
    @JsonProperty("error")
    private String error;
    @JsonProperty("aid")
    private String aid;

    @JsonProperty("result")
    public Result getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(Result result) {
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

}