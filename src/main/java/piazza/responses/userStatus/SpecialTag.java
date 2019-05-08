package piazza.responses.userStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "nr",
        "name"
})
public class SpecialTag {

    @JsonProperty("nr")
    private Long nr;
    @JsonProperty("name")
    private String name;

    @JsonProperty("nr")
    public Long getNr() {
        return nr;
    }

    @JsonProperty("nr")
    public void setNr(Long nr) {
        this.nr = nr;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

}
