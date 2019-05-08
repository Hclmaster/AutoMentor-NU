package piazza.responses.userStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "photo_original",
        "facebook",
        "profile",
        "photo",
        "networks",
        "sid",
        "last_network",
        "emails",
        "can_anonymize",
        "last_content",
        "photo_original_url",
        "feed_prefetch",
        "new_questions",
        "careers_at_a_glance_data",
        "name",
        "can_admin",
        "need_password",
        "isUS",
        "isCA",
        "id",
        "photo_url",
        "config",
        "email",
        "activated"
})
public class Result {

    @JsonProperty("photo_original")
    private String photoOriginal;
    @JsonProperty("facebook")
    private Facebook facebook;
    @JsonProperty("profile")
    private Profile profile;
    @JsonProperty("photo")
    private String photo;
    @JsonProperty("networks")
    private List<Network> networks = null;
    @JsonProperty("sid")
    private String sid;
    @JsonProperty("last_network")
    private String lastNetwork;
    @JsonProperty("emails")
    private List<String> emails = null;
    @JsonProperty("can_anonymize")
    private Boolean canAnonymize;
    @JsonProperty("last_content")
    private LastContent lastContent;
    @JsonProperty("photo_original_url")
    private Object photoOriginalUrl;
    @JsonProperty("feed_prefetch")
    private FeedPrefetch feedPrefetch;
    @JsonProperty("new_questions")
    private Map<String, Long> newQuestions;
    @JsonProperty("careers_at_a_glance_data")
    private CareersAtAGlanceData careersAtAGlanceData;
    @JsonProperty("name")
    private String name;
    @JsonProperty("can_admin")
    private Map<String, Long> canAdmin;
    @JsonProperty("need_password")
    private Boolean needPassword;
    @JsonProperty("isUS")
    private Boolean isUS;
    @JsonProperty("isCA")
    private Boolean isCA;
    @JsonProperty("id")
    private String id;
    @JsonProperty("photo_url")
    private Object photoUrl;
    @JsonProperty("config")
    private Config_ config;
    @JsonProperty("email")
    private String email;
    @JsonProperty("activated")
    private Long activated;

    @JsonProperty("photo_original")
    public String getPhotoOriginal() {
        return photoOriginal;
    }

    @JsonProperty("photo_original")
    public void setPhotoOriginal(String photoOriginal) {
        this.photoOriginal = photoOriginal;
    }

    @JsonProperty("facebook")
    public Facebook getFacebook() {
        return facebook;
    }

    @JsonProperty("facebook")
    public void setFacebook(Facebook facebook) {
        this.facebook = facebook;
    }

    @JsonProperty("profile")
    public Profile getProfile() {
        return profile;
    }

    @JsonProperty("profile")
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @JsonProperty("photo")
    public String getPhoto() {
        return photo;
    }

    @JsonProperty("photo")
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @JsonProperty("networks")
    public List<Network> getNetworks() {
        return networks;
    }

    @JsonProperty("networks")
    public void setNetworks(List<Network> networks) {
        this.networks = networks;
    }

    @JsonProperty("sid")
    public String getSid() {
        return sid;
    }

    @JsonProperty("sid")
    public void setSid(String sid) {
        this.sid = sid;
    }

    @JsonProperty("last_network")
    public String getLastNetwork() {
        return lastNetwork;
    }

    @JsonProperty("last_network")
    public void setLastNetwork(String lastNetwork) {
        this.lastNetwork = lastNetwork;
    }

    @JsonProperty("emails")
    public List<String> getEmails() {
        return emails;
    }

    @JsonProperty("emails")
    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    @JsonProperty("can_anonymize")
    public Boolean getCanAnonymize() {
        return canAnonymize;
    }

    @JsonProperty("can_anonymize")
    public void setCanAnonymize(Boolean canAnonymize) {
        this.canAnonymize = canAnonymize;
    }

    @JsonProperty("last_content")
    public LastContent getLastContent() {
        return lastContent;
    }

    @JsonProperty("last_content")
    public void setLastContent(LastContent lastContent) {
        this.lastContent = lastContent;
    }

    @JsonProperty("photo_original_url")
    public Object getPhotoOriginalUrl() {
        return photoOriginalUrl;
    }

    @JsonProperty("photo_original_url")
    public void setPhotoOriginalUrl(Object photoOriginalUrl) {
        this.photoOriginalUrl = photoOriginalUrl;
    }

    @JsonProperty("feed_prefetch")
    public FeedPrefetch getFeedPrefetch() {
        return feedPrefetch;
    }

    @JsonProperty("feed_prefetch")
    public void setFeedPrefetch(FeedPrefetch feedPrefetch) {
        this.feedPrefetch = feedPrefetch;
    }

    @JsonProperty("new_questions")
    public Map<String, Long> getNewQuestions() {
        return newQuestions;
    }

    @JsonProperty("new_questions")
    public void setNewQuestions(Map<String, Long> newQuestions) {
        this.newQuestions = newQuestions;
    }

    @JsonProperty("careers_at_a_glance_data")
    public CareersAtAGlanceData getCareersAtAGlanceData() {
        return careersAtAGlanceData;
    }

    @JsonProperty("careers_at_a_glance_data")
    public void setCareersAtAGlanceData(CareersAtAGlanceData careersAtAGlanceData) {
        this.careersAtAGlanceData = careersAtAGlanceData;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("can_admin")
    public Map<String, Long> getCanAdmin() {
        return canAdmin;
    }

    @JsonProperty("can_admin")
    public void setCanAdmin(Map<String, Long> canAdmin) {
        this.canAdmin = canAdmin;
    }

    @JsonProperty("need_password")
    public Boolean getNeedPassword() {
        return needPassword;
    }

    @JsonProperty("need_password")
    public void setNeedPassword(Boolean needPassword) {
        this.needPassword = needPassword;
    }

    @JsonProperty("isUS")
    public Boolean getIsUS() {
        return isUS;
    }

    @JsonProperty("isUS")
    public void setIsUS(Boolean isUS) {
        this.isUS = isUS;
    }

    @JsonProperty("isCA")
    public Boolean getIsCA() {
        return isCA;
    }

    @JsonProperty("isCA")
    public void setIsCA(Boolean isCA) {
        this.isCA = isCA;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("photo_url")
    public Object getPhotoUrl() {
        return photoUrl;
    }

    @JsonProperty("photo_url")
    public void setPhotoUrl(Object photoUrl) {
        this.photoUrl = photoUrl;
    }

    @JsonProperty("config")
    public Config_ getConfig() {
        return config;
    }

    @JsonProperty("config")
    public void setConfig(Config_ config) {
        this.config = config;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("activated")
    public Long getActivated() {
        return activated;
    }

    @JsonProperty("activated")
    public void setActivated(Long activated) {
        this.activated = activated;
    }

}
