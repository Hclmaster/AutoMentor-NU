package piazza.responses.userStatus;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "visibility",
        "name",
        "date_title",
        "title",
        "has_date",
        "disabled_pagination",
        "page_size"
})
public class ResourceSection {

    @JsonProperty("visibility")
    private Boolean visibility;
    @JsonProperty("name")
    private String name;
    @JsonProperty("date_title")
    private String dateTitle;
    @JsonProperty("title")
    private String title;
    @JsonProperty("has_date")
    private Boolean hasDate;
    @JsonProperty("disabled_pagination")
    private Boolean disabledPagination;
    @JsonProperty("page_size")
    private Long pageSize;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("visibility")
    public Boolean getVisibility() {
        return visibility;
    }

    @JsonProperty("visibility")
    public void setVisibility(Boolean visibility) {
        this.visibility = visibility;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("date_title")
    public String getDateTitle() {
        return dateTitle;
    }

    @JsonProperty("date_title")
    public void setDateTitle(String dateTitle) {
        this.dateTitle = dateTitle;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("has_date")
    public Boolean getHasDate() {
        return hasDate;
    }

    @JsonProperty("has_date")
    public void setHasDate(Boolean hasDate) {
        this.hasDate = hasDate;
    }

    @JsonProperty("disabled_pagination")
    public Boolean getDisabledPagination() {
        return disabledPagination;
    }

    @JsonProperty("disabled_pagination")
    public void setDisabledPagination(Boolean disabledPagination) {
        this.disabledPagination = disabledPagination;
    }

    @JsonProperty("page_size")
    public Long getPageSize() {
        return pageSize;
    }

    @JsonProperty("page_size")
    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
