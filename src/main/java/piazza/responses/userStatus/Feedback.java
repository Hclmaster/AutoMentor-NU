package piazza.responses.userStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "list"
})
public class Feedback {

    @JsonProperty("list")
    private List<String> list = null;

    @JsonProperty("list")
    public List<String> getList() {
        return list;
    }

    @JsonProperty("list")
    public void setList(List<String> list) {
        this.list = list;
    }

}
