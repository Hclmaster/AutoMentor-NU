package piazza.responses.userStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "resource_sections",
        "announcements"
})
public class PublicVisibilitySettings {

    @JsonProperty("resource_sections")
    private Map<String, Boolean> resourceSections;
    @JsonProperty("announcements")
    private Boolean announcements;

    @JsonProperty("resource_sections")
    public Map<String, Boolean> getResourceSections() {
        return resourceSections;
    }

    @JsonProperty("resource_sections")
    public void setResourceSections(Map<String, Boolean> resourceSections) {
        this.resourceSections = resourceSections;
    }

    @JsonProperty("announcements")
    public Boolean getAnnouncements() {
        return announcements;
    }

    @JsonProperty("announcements")
    public void setAnnouncements(Boolean announcements) {
        this.announcements = announcements;
    }

}
