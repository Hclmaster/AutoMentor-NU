package piazza.responses.userStatus;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "seen_message",
        "feed_details",
        "feed",
        "email_prefs",
        "enroll_time",
        "email_throttle",
        "email_throttle_last",
        "careers_notifications",
        "notification_type_last_calculated",
        "last_networks",
        "logins",
        "job_dropdowns_last_seen",
        "in_roster",
        "feed_digest",
        "no_feed",
        "published",
        "resume_dropdown_last_seen",
        "techtour_view_counter",
        "techtour_view_counter_winter_2017",
        "default_editor",
        "techtour_view_counter_summer_2018",
        "techtour_view_counter_summer_2019",
        "hide_stats",
        "roles"
})
public class Config_ {

    @JsonProperty("seen_message")
    private List<String> seenMessage = null;
    @JsonProperty("feed_details")
    private String feedDetails;
    @JsonProperty("feed")
    private Feed_ feed;
    @JsonProperty("email_prefs")
    private Map<String, Object> emailPrefs;
    @JsonProperty("enroll_time")
    private Map<String, Long> enrollTime;
    @JsonProperty("email_throttle")
    private Map<String, Long> emailThrottle;
    @JsonProperty("email_throttle_last")
    private Map<String, Long> emailThrottleLast;
    @JsonProperty("careers_notifications")
    private List<CareersNotification> careersNotifications = null;
    @JsonProperty("notification_type_last_calculated")
    private NotificationTypeLastCalculated notificationTypeLastCalculated;
    @JsonProperty("last_networks")
    private List<String> lastNetworks = null;
    @JsonProperty("logins")
    private Long logins;
    @JsonProperty("job_dropdowns_last_seen")
    private String jobDropdownsLastSeen;
    @JsonProperty("in_roster")
    private List<String> inRoster = null;
    @JsonProperty("feed_digest")
    private FeedDigest feedDigest;
    @JsonProperty("no_feed")
    private Boolean noFeed;
    @JsonProperty("published")
    private Boolean published;
    @JsonProperty("resume_dropdown_last_seen")
    private String resumeDropdownLastSeen;
    @JsonProperty("techtour_view_counter")
    private Long techtourViewCounter;
    @JsonProperty("techtour_view_counter_winter_2017")
    private Long techtourViewCounterWinter2017;
    @JsonProperty("default_editor")
    private String defaultEditor;
    @JsonProperty("techtour_view_counter_summer_2018")
    private Long techtourViewCounterSummer2018;
    @JsonProperty("techtour_view_counter_summer_2019")
    private Long techtourViewCounterSummer2019;
    @JsonProperty("hide_stats")
    private String hideStats;
    @JsonProperty("roles")
    private Map<String, String> roles;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("seen_message")
    public List<String> getSeenMessage() {
        return seenMessage;
    }

    @JsonProperty("seen_message")
    public void setSeenMessage(List<String> seenMessage) {
        this.seenMessage = seenMessage;
    }

    @JsonProperty("feed_details")
    public String getFeedDetails() {
        return feedDetails;
    }

    @JsonProperty("feed_details")
    public void setFeedDetails(String feedDetails) {
        this.feedDetails = feedDetails;
    }

    @JsonProperty("feed")
    public Feed_ getFeed() {
        return feed;
    }

    @JsonProperty("feed")
    public void setFeed(Feed_ feed) {
        this.feed = feed;
    }

    @JsonProperty("email_prefs")
    public Map<String, Object> getEmailPrefs() {
        return emailPrefs;
    }

    @JsonProperty("email_prefs")
    public void setEmailPrefs(Map<String, Object> emailPrefs) {
        this.emailPrefs = emailPrefs;
    }

    @JsonProperty("enroll_time")
    public Map<String, Long> getEnrollTime() {
        return enrollTime;
    }

    @JsonProperty("enroll_time")
    public void setEnrollTime(Map<String, Long> enrollTime) {
        this.enrollTime = enrollTime;
    }

    @JsonProperty("email_throttle")
    public Map<String, Long> getEmailThrottle() {
        return emailThrottle;
    }

    @JsonProperty("email_throttle")
    public void setEmailThrottle(Map<String, Long> emailThrottle) {
        this.emailThrottle = emailThrottle;
    }

    @JsonProperty("email_throttle_last")
    public Map<String, Long> getEmailThrottleLast() {
        return emailThrottleLast;
    }

    @JsonProperty("email_throttle_last")
    public void setEmailThrottleLast(Map<String, Long> emailThrottleLast) {
        this.emailThrottleLast = emailThrottleLast;
    }

    @JsonProperty("careers_notifications")
    public List<CareersNotification> getCareersNotifications() {
        return careersNotifications;
    }

    @JsonProperty("careers_notifications")
    public void setCareersNotifications(List<CareersNotification> careersNotifications) {
        this.careersNotifications = careersNotifications;
    }

    @JsonProperty("notification_type_last_calculated")
    public NotificationTypeLastCalculated getNotificationTypeLastCalculated() {
        return notificationTypeLastCalculated;
    }

    @JsonProperty("notification_type_last_calculated")
    public void setNotificationTypeLastCalculated(NotificationTypeLastCalculated notificationTypeLastCalculated) {
        this.notificationTypeLastCalculated = notificationTypeLastCalculated;
    }

    @JsonProperty("last_networks")
    public List<String> getLastNetworks() {
        return lastNetworks;
    }

    @JsonProperty("last_networks")
    public void setLastNetworks(List<String> lastNetworks) {
        this.lastNetworks = lastNetworks;
    }

    @JsonProperty("logins")
    public Long getLogins() {
        return logins;
    }

    @JsonProperty("logins")
    public void setLogins(Long logins) {
        this.logins = logins;
    }

    @JsonProperty("job_dropdowns_last_seen")
    public String getJobDropdownsLastSeen() {
        return jobDropdownsLastSeen;
    }

    @JsonProperty("job_dropdowns_last_seen")
    public void setJobDropdownsLastSeen(String jobDropdownsLastSeen) {
        this.jobDropdownsLastSeen = jobDropdownsLastSeen;
    }

    @JsonProperty("in_roster")
    public List<String> getInRoster() {
        return inRoster;
    }

    @JsonProperty("in_roster")
    public void setInRoster(List<String> inRoster) {
        this.inRoster = inRoster;
    }

    @JsonProperty("feed_digest")
    public FeedDigest getFeedDigest() {
        return feedDigest;
    }

    @JsonProperty("feed_digest")
    public void setFeedDigest(FeedDigest feedDigest) {
        this.feedDigest = feedDigest;
    }

    @JsonProperty("no_feed")
    public Boolean getNoFeed() {
        return noFeed;
    }

    @JsonProperty("no_feed")
    public void setNoFeed(Boolean noFeed) {
        this.noFeed = noFeed;
    }

    @JsonProperty("published")
    public Boolean getPublished() {
        return published;
    }

    @JsonProperty("published")
    public void setPublished(Boolean published) {
        this.published = published;
    }

    @JsonProperty("resume_dropdown_last_seen")
    public String getResumeDropdownLastSeen() {
        return resumeDropdownLastSeen;
    }

    @JsonProperty("resume_dropdown_last_seen")
    public void setResumeDropdownLastSeen(String resumeDropdownLastSeen) {
        this.resumeDropdownLastSeen = resumeDropdownLastSeen;
    }

    @JsonProperty("techtour_view_counter")
    public Long getTechtourViewCounter() {
        return techtourViewCounter;
    }

    @JsonProperty("techtour_view_counter")
    public void setTechtourViewCounter(Long techtourViewCounter) {
        this.techtourViewCounter = techtourViewCounter;
    }

    @JsonProperty("techtour_view_counter_winter_2017")
    public Long getTechtourViewCounterWinter2017() {
        return techtourViewCounterWinter2017;
    }

    @JsonProperty("techtour_view_counter_winter_2017")
    public void setTechtourViewCounterWinter2017(Long techtourViewCounterWinter2017) {
        this.techtourViewCounterWinter2017 = techtourViewCounterWinter2017;
    }

    @JsonProperty("default_editor")
    public String getDefaultEditor() {
        return defaultEditor;
    }

    @JsonProperty("default_editor")
    public void setDefaultEditor(String defaultEditor) {
        this.defaultEditor = defaultEditor;
    }

    @JsonProperty("techtour_view_counter_summer_2018")
    public Long getTechtourViewCounterSummer2018() {
        return techtourViewCounterSummer2018;
    }

    @JsonProperty("techtour_view_counter_summer_2018")
    public void setTechtourViewCounterSummer2018(Long techtourViewCounterSummer2018) {
        this.techtourViewCounterSummer2018 = techtourViewCounterSummer2018;
    }

    @JsonProperty("techtour_view_counter_summer_2019")
    public Long getTechtourViewCounterSummer2019() {
        return techtourViewCounterSummer2019;
    }

    @JsonProperty("techtour_view_counter_summer_2019")
    public void setTechtourViewCounterSummer2019(Long techtourViewCounterSummer2019) {
        this.techtourViewCounterSummer2019 = techtourViewCounterSummer2019;
    }

    @JsonProperty("hide_stats")
    public String getHideStats() {
        return hideStats;
    }

    @JsonProperty("hide_stats")
    public void setHideStats(String hideStats) {
        this.hideStats = hideStats;
    }

    @JsonProperty("roles")
    public Map<String, String> getRoles() {
        return roles;
    }

    @JsonProperty("roles")
    public void setRoles(Map<String, String> roles) {
        this.roles = roles;
    }


    @JsonGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
