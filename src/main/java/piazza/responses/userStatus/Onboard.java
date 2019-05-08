package piazza.responses.userStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "add_inst",
        "add_stud"
})
public class Onboard {

    @JsonProperty("add_inst")
    private Long addInst;
    @JsonProperty("add_stud")
    private Long addStud;

    @JsonProperty("add_inst")
    public Long getAddInst() {
        return addInst;
    }

    @JsonProperty("add_inst")
    public void setAddInst(Long addInst) {
        this.addInst = addInst;
    }

    @JsonProperty("add_stud")
    public Long getAddStud() {
        return addStud;
    }

    @JsonProperty("add_stud")
    public void setAddStud(Long addStud) {
        this.addStud = addStud;
    }

}
