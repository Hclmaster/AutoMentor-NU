package piazza.responses.userStatus;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "difficulty",
        "subject",
        "category",
        "tips_tricks_nr",
        "get_familiar_nr",
        "introduce_piazza_nr",
        "reg_user_count",
        "resource_sections",
        "public_visibility_settings",
        "cloned_from",
        "seen_message",
        "disable_syntax",
        "feedback",
        "timer",
        "disable_student_polls",
        "enable_mentions_students",
        "disable_folders",
        "disable_mentions",
        "default_posts_to_private",
        "onboard",
        "roles"
})
public class Config {

    @JsonProperty("difficulty")
    private String difficulty;
    @JsonProperty("subject")
    private String subject;
    @JsonProperty("category")
    private String category;
    @JsonProperty("tips_tricks_nr")
    private Long tipsTricksNr;
    @JsonProperty("get_familiar_nr")
    private Long getFamiliarNr;
    @JsonProperty("introduce_piazza_nr")
    private Long introducePiazzaNr;
    @JsonProperty("reg_user_count")
    private Long regUserCount;
    @JsonProperty("resource_sections")
    private List<ResourceSection> resourceSections = null;
    @JsonProperty("public_visibility_settings")
    private PublicVisibilitySettings publicVisibilitySettings;
    @JsonProperty("cloned_from")
    private String clonedFrom;
    @JsonProperty("seen_message")
    private List<String> seenMessage = null;
    @JsonProperty("disable_syntax")
    private Boolean disableSyntax;
    @JsonProperty("feedback")
    private Feedback feedback;
    @JsonProperty("timer")
    private Timer timer;
    @JsonProperty("disable_student_polls")
    private Boolean disableStudentPolls;
    @JsonProperty("enable_mentions_students")
    private Boolean enableMentionsStudents;
    @JsonProperty("disable_folders")
    private Boolean disableFolders;
    @JsonProperty("disable_mentions")
    private Boolean disableMentions;
    @JsonProperty("default_posts_to_private")
    private Boolean defaultPostsToPrivate;
    @JsonProperty("onboard")
    private Onboard onboard;
    @JsonProperty("roles")
    private Roles roles;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("difficulty")
    public String getDifficulty() {
        return difficulty;
    }

    @JsonProperty("difficulty")
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @JsonProperty("subject")
    public String getSubject() {
        return subject;
    }

    @JsonProperty("subject")
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("tips_tricks_nr")
    public Long getTipsTricksNr() {
        return tipsTricksNr;
    }

    @JsonProperty("tips_tricks_nr")
    public void setTipsTricksNr(Long tipsTricksNr) {
        this.tipsTricksNr = tipsTricksNr;
    }

    @JsonProperty("get_familiar_nr")
    public Long getGetFamiliarNr() {
        return getFamiliarNr;
    }

    @JsonProperty("get_familiar_nr")
    public void setGetFamiliarNr(Long getFamiliarNr) {
        this.getFamiliarNr = getFamiliarNr;
    }

    @JsonProperty("introduce_piazza_nr")
    public Long getIntroducePiazzaNr() {
        return introducePiazzaNr;
    }

    @JsonProperty("introduce_piazza_nr")
    public void setIntroducePiazzaNr(Long introducePiazzaNr) {
        this.introducePiazzaNr = introducePiazzaNr;
    }

    @JsonProperty("reg_user_count")
    public Long getRegUserCount() {
        return regUserCount;
    }

    @JsonProperty("reg_user_count")
    public void setRegUserCount(Long regUserCount) {
        this.regUserCount = regUserCount;
    }

    @JsonProperty("resource_sections")
    public List<ResourceSection> getResourceSections() {
        return resourceSections;
    }

    @JsonProperty("resource_sections")
    public void setResourceSections(List<ResourceSection> resourceSections) {
        this.resourceSections = resourceSections;
    }

    @JsonProperty("public_visibility_settings")
    public PublicVisibilitySettings getPublicVisibilitySettings() {
        return publicVisibilitySettings;
    }

    @JsonProperty("public_visibility_settings")
    public void setPublicVisibilitySettings(PublicVisibilitySettings publicVisibilitySettings) {
        this.publicVisibilitySettings = publicVisibilitySettings;
    }

    @JsonProperty("cloned_from")
    public String getClonedFrom() {
        return clonedFrom;
    }

    @JsonProperty("cloned_from")
    public void setClonedFrom(String clonedFrom) {
        this.clonedFrom = clonedFrom;
    }

    @JsonProperty("seen_message")
    public List<String> getSeenMessage() {
        return seenMessage;
    }

    @JsonProperty("seen_message")
    public void setSeenMessage(List<String> seenMessage) {
        this.seenMessage = seenMessage;
    }

    @JsonProperty("disable_syntax")
    public Boolean getDisableSyntax() {
        return disableSyntax;
    }

    @JsonProperty("disable_syntax")
    public void setDisableSyntax(Boolean disableSyntax) {
        this.disableSyntax = disableSyntax;
    }

    @JsonProperty("feedback")
    public Feedback getFeedback() {
        return feedback;
    }

    @JsonProperty("feedback")
    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    @JsonProperty("timer")
    public Timer getTimer() {
        return timer;
    }

    @JsonProperty("timer")
    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    @JsonProperty("disable_student_polls")
    public Boolean getDisableStudentPolls() {
        return disableStudentPolls;
    }

    @JsonProperty("disable_student_polls")
    public void setDisableStudentPolls(Boolean disableStudentPolls) {
        this.disableStudentPolls = disableStudentPolls;
    }

    @JsonProperty("enable_mentions_students")
    public Boolean getEnableMentionsStudents() {
        return enableMentionsStudents;
    }

    @JsonProperty("enable_mentions_students")
    public void setEnableMentionsStudents(Boolean enableMentionsStudents) {
        this.enableMentionsStudents = enableMentionsStudents;
    }

    @JsonProperty("disable_folders")
    public Boolean getDisableFolders() {
        return disableFolders;
    }

    @JsonProperty("disable_folders")
    public void setDisableFolders(Boolean disableFolders) {
        this.disableFolders = disableFolders;
    }

    @JsonProperty("disable_mentions")
    public Boolean getDisableMentions() {
        return disableMentions;
    }

    @JsonProperty("disable_mentions")
    public void setDisableMentions(Boolean disableMentions) {
        this.disableMentions = disableMentions;
    }

    @JsonProperty("default_posts_to_private")
    public Boolean getDefaultPostsToPrivate() {
        return defaultPostsToPrivate;
    }

    @JsonProperty("default_posts_to_private")
    public void setDefaultPostsToPrivate(Boolean defaultPostsToPrivate) {
        this.defaultPostsToPrivate = defaultPostsToPrivate;
    }

    @JsonProperty("onboard")
    public Onboard getOnboard() {
        return onboard;
    }

    @JsonProperty("onboard")
    public void setOnboard(Onboard onboard) {
        this.onboard = onboard;
    }

    @JsonProperty("roles")
    public Roles getRoles() {
        return roles;
    }

    @JsonProperty("roles")
    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @JsonGetter
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
