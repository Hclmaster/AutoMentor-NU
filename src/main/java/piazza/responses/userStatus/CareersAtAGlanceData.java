package piazza.responses.userStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "nof_num_searches",
        "nof_num_companies",
        "nof_num_students_viewed"
})
public class CareersAtAGlanceData {

    @JsonProperty("nof_num_searches")
    private Long nofNumSearches;
    @JsonProperty("nof_num_companies")
    private Long nofNumCompanies;
    @JsonProperty("nof_num_students_viewed")
    private Long nofNumStudentsViewed;

    @JsonProperty("nof_num_searches")
    public Long getNofNumSearches() {
        return nofNumSearches;
    }

    @JsonProperty("nof_num_searches")
    public void setNofNumSearches(Long nofNumSearches) {
        this.nofNumSearches = nofNumSearches;
    }

    @JsonProperty("nof_num_companies")
    public Long getNofNumCompanies() {
        return nofNumCompanies;
    }

    @JsonProperty("nof_num_companies")
    public void setNofNumCompanies(Long nofNumCompanies) {
        this.nofNumCompanies = nofNumCompanies;
    }

    @JsonProperty("nof_num_students_viewed")
    public Long getNofNumStudentsViewed() {
        return nofNumStudentsViewed;
    }

    @JsonProperty("nof_num_students_viewed")
    public void setNofNumStudentsViewed(Long nofNumStudentsViewed) {
        this.nofNumStudentsViewed = nofNumStudentsViewed;
    }

}
