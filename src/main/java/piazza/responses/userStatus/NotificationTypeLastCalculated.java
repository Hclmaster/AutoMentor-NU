package piazza.responses.userStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "upcoming_events",
        "classmates_company_view",
        "appeared_in_search",
        "companies_online"
})
public class NotificationTypeLastCalculated {

    @JsonProperty("upcoming_events")
    private Long upcomingEvents;
    @JsonProperty("classmates_company_view")
    private Long classmatesCompanyView;
    @JsonProperty("appeared_in_search")
    private Long appearedInSearch;
    @JsonProperty("companies_online")
    private Long companiesOnline;

    @JsonProperty("upcoming_events")
    public Long getUpcomingEvents() {
        return upcomingEvents;
    }

    @JsonProperty("upcoming_events")
    public void setUpcomingEvents(Long upcomingEvents) {
        this.upcomingEvents = upcomingEvents;
    }

    @JsonProperty("classmates_company_view")
    public Long getClassmatesCompanyView() {
        return classmatesCompanyView;
    }

    @JsonProperty("classmates_company_view")
    public void setClassmatesCompanyView(Long classmatesCompanyView) {
        this.classmatesCompanyView = classmatesCompanyView;
    }

    @JsonProperty("appeared_in_search")
    public Long getAppearedInSearch() {
        return appearedInSearch;
    }

    @JsonProperty("appeared_in_search")
    public void setAppearedInSearch(Long appearedInSearch) {
        this.appearedInSearch = appearedInSearch;
    }

    @JsonProperty("companies_online")
    public Long getCompaniesOnline() {
        return companiesOnline;
    }

    @JsonProperty("companies_online")
    public void setCompaniesOnline(Long companiesOnline) {
        this.companiesOnline = companiesOnline;
    }

}
