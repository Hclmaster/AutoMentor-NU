package piazza.responses.userStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "instructor",
        "instructor_upd",
        "popular_count",
        "popular",
        "instructor_count"
})
public class Tags {

    @JsonProperty("instructor")
    private List<String> instructor = null;
    @JsonProperty("instructor_upd")
    private Map<String, Long> instructorUpd;
    @JsonProperty("popular_count")
    private Map<String, Long> popularCount;
    @JsonProperty("popular")
    private List<String> popular = null;
    @JsonProperty("instructor_count")
    private Map<String, Long> instructorCount;

    @JsonProperty("instructor")
    public List<String> getInstructor() {
        return instructor;
    }

    @JsonProperty("instructor")
    public void setInstructor(List<String> instructor) {
        this.instructor = instructor;
    }

    @JsonProperty("instructor_upd")
    public Map<String, Long> getInstructorUpd() {
        return instructorUpd;
    }

    @JsonProperty("instructor_upd")
    public void setInstructorUpd(Map<String, Long> instructorUpd) {
        this.instructorUpd = instructorUpd;
    }

    @JsonProperty("popular_count")
    public Map<String, Long> getPopularCount() {
        return popularCount;
    }

    @JsonProperty("popular_count")
    public void setPopularCount(Map<String, Long> popularCount) {
        this.popularCount = popularCount;
    }

    @JsonProperty("popular")
    public List<String> getPopular() {
        return popular;
    }

    @JsonProperty("popular")
    public void setPopular(List<String> popular) {
        this.popular = popular;
    }

    @JsonProperty("instructor_count")
    public Map<String, Long> getInstructorCount() {
        return instructorCount;
    }

    @JsonProperty("instructor_count")
    public void setInstructorCount(Map<String, Long> instructorCount) {
        this.instructorCount = instructorCount;
    }

}
