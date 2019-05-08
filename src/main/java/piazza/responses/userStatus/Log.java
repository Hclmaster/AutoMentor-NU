package piazza.responses.userStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "t",
        "u",
        "n"
})
public class Log {

    @JsonProperty("t")
    private String t;
    @JsonProperty("u")
    private String u;
    @JsonProperty("n")
    private String n;

    @JsonProperty("t")
    public String getT() {
        return t;
    }

    @JsonProperty("t")
    public void setT(String t) {
        this.t = t;
    }

    @JsonProperty("u")
    public String getU() {
        return u;
    }

    @JsonProperty("u")
    public void setU(String u) {
        this.u = u;
    }

    @JsonProperty("n")
    public String getN() {
        return n;
    }

    @JsonProperty("n")
    public void setN(String n) {
        this.n = n;
    }

}
