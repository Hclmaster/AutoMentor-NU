package piazza.models;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "folders",
        "nr",
        "data",
        "created",
        "bucket_order",
        "no_answer_followup",
        "change_log",
        "bucket_name",
        "history",
        "type",
        "tags",
        "tag_good",
        "unique_views",
        "children",
        "tag_good_arr",
        "id",
        "config",
        "status",
        "upvote_ids",
        "request_instructor",
        "request_instructor_me",
        "bookmarked",
        "num_favorites",
        "my_favorite",
        "is_bookmarked",
        "is_tag_good",
        "q_edits",
        "i_edits",
        "s_edits",
        "t",
        "default_anonymity"
})
public class Result {

    @JsonProperty("folders")
    private List<String> folders = null;
    @JsonProperty("nr")
    private Integer nr;
    @JsonProperty("data")
    private Data data;
    @JsonProperty("created")
    private String created;
    @JsonProperty("bucket_order")
    private Integer bucketOrder;
    @JsonProperty("no_answer_followup")
    private Integer noAnswerFollowup;
    @JsonProperty("change_log")
    private List<ChangeLog> changeLog = null;
    @JsonProperty("bucket_name")
    private String bucketName;
    @JsonProperty("history")
    private List<History> history = null;
    @JsonProperty("type")
    private String type;
    @JsonProperty("tags")
    private List<String> tags = null;
    @JsonProperty("tag_good")
    private List<Object> tagGood = null;
    @JsonProperty("unique_views")
    private Integer uniqueViews;
    @JsonProperty("children")
    private List<Object> children = null;
    @JsonProperty("tag_good_arr")
    private List<Object> tagGoodArr = null;
    @JsonProperty("id")
    private String id;
    @JsonProperty("config")
    private Config config;
    @JsonProperty("status")
    private String status;
    @JsonProperty("upvote_ids")
    private List<Object> upvoteIds = null;
    @JsonProperty("request_instructor")
    private Integer requestInstructor;
    @JsonProperty("request_instructor_me")
    private Boolean requestInstructorMe;
    @JsonProperty("bookmarked")
    private Integer bookmarked;
    @JsonProperty("num_favorites")
    private Integer numFavorites;
    @JsonProperty("my_favorite")
    private Boolean myFavorite;
    @JsonProperty("is_bookmarked")
    private Boolean isBookmarked;
    @JsonProperty("is_tag_good")
    private Boolean isTagGood;
    @JsonProperty("q_edits")
    private List<Object> qEdits = null;
    @JsonProperty("i_edits")
    private List<Object> iEdits = null;
    @JsonProperty("s_edits")
    private List<Object> sEdits = null;
    @JsonProperty("t")
    private Long t;
    @JsonProperty("default_anonymity")
    private String defaultAnonymity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("folders")
    public List<String> getFolders() {
        return folders;
    }

    @JsonProperty("folders")
    public void setFolders(List<String> folders) {
        this.folders = folders;
    }

    @JsonProperty("nr")
    public Integer getNr() {
        return nr;
    }

    @JsonProperty("nr")
    public void setNr(Integer nr) {
        this.nr = nr;
    }

    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data data) {
        this.data = data;
    }

    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }

    @JsonProperty("bucket_order")
    public Integer getBucketOrder() {
        return bucketOrder;
    }

    @JsonProperty("bucket_order")
    public void setBucketOrder(Integer bucketOrder) {
        this.bucketOrder = bucketOrder;
    }

    @JsonProperty("no_answer_followup")
    public Integer getNoAnswerFollowup() {
        return noAnswerFollowup;
    }

    @JsonProperty("no_answer_followup")
    public void setNoAnswerFollowup(Integer noAnswerFollowup) {
        this.noAnswerFollowup = noAnswerFollowup;
    }

    @JsonProperty("change_log")
    public List<ChangeLog> getChangeLog() {
        return changeLog;
    }

    @JsonProperty("change_log")
    public void setChangeLog(List<ChangeLog> changeLog) {
        this.changeLog = changeLog;
    }

    @JsonProperty("bucket_name")
    public String getBucketName() {
        return bucketName;
    }

    @JsonProperty("bucket_name")
    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    @JsonProperty("history")
    public List<History> getHistory() {
        return history;
    }

    @JsonProperty("history")
    public void setHistory(List<History> history) {
        this.history = history;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("tags")
    public List<String> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @JsonProperty("tag_good")
    public List<Object> getTagGood() {
        return tagGood;
    }

    @JsonProperty("tag_good")
    public void setTagGood(List<Object> tagGood) {
        this.tagGood = tagGood;
    }

    @JsonProperty("unique_views")
    public Integer getUniqueViews() {
        return uniqueViews;
    }

    @JsonProperty("unique_views")
    public void setUniqueViews(Integer uniqueViews) {
        this.uniqueViews = uniqueViews;
    }

    @JsonProperty("children")
    public List<Object> getChildren() {
        return children;
    }

    @JsonProperty("children")
    public void setChildren(List<Object> children) {
        this.children = children;
    }

    @JsonProperty("tag_good_arr")
    public List<Object> getTagGoodArr() {
        return tagGoodArr;
    }

    @JsonProperty("tag_good_arr")
    public void setTagGoodArr(List<Object> tagGoodArr) {
        this.tagGoodArr = tagGoodArr;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("config")
    public Config getConfig() {
        return config;
    }

    @JsonProperty("config")
    public void setConfig(Config config) {
        this.config = config;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("upvote_ids")
    public List<Object> getUpvoteIds() {
        return upvoteIds;
    }

    @JsonProperty("upvote_ids")
    public void setUpvoteIds(List<Object> upvoteIds) {
        this.upvoteIds = upvoteIds;
    }

    @JsonProperty("request_instructor")
    public Integer getRequestInstructor() {
        return requestInstructor;
    }

    @JsonProperty("request_instructor")
    public void setRequestInstructor(Integer requestInstructor) {
        this.requestInstructor = requestInstructor;
    }

    @JsonProperty("request_instructor_me")
    public Boolean getRequestInstructorMe() {
        return requestInstructorMe;
    }

    @JsonProperty("request_instructor_me")
    public void setRequestInstructorMe(Boolean requestInstructorMe) {
        this.requestInstructorMe = requestInstructorMe;
    }

    @JsonProperty("bookmarked")
    public Integer getBookmarked() {
        return bookmarked;
    }

    @JsonProperty("bookmarked")
    public void setBookmarked(Integer bookmarked) {
        this.bookmarked = bookmarked;
    }

    @JsonProperty("num_favorites")
    public Integer getNumFavorites() {
        return numFavorites;
    }

    @JsonProperty("num_favorites")
    public void setNumFavorites(Integer numFavorites) {
        this.numFavorites = numFavorites;
    }

    @JsonProperty("my_favorite")
    public Boolean getMyFavorite() {
        return myFavorite;
    }

    @JsonProperty("my_favorite")
    public void setMyFavorite(Boolean myFavorite) {
        this.myFavorite = myFavorite;
    }

    @JsonProperty("is_bookmarked")
    public Boolean getIsBookmarked() {
        return isBookmarked;
    }

    @JsonProperty("is_bookmarked")
    public void setIsBookmarked(Boolean isBookmarked) {
        this.isBookmarked = isBookmarked;
    }

    @JsonProperty("is_tag_good")
    public Boolean getIsTagGood() {
        return isTagGood;
    }

    @JsonProperty("is_tag_good")
    public void setIsTagGood(Boolean isTagGood) {
        this.isTagGood = isTagGood;
    }

    @JsonProperty("q_edits")
    public List<Object> getQEdits() {
        return qEdits;
    }

    @JsonProperty("q_edits")
    public void setQEdits(List<Object> qEdits) {
        this.qEdits = qEdits;
    }

    @JsonProperty("i_edits")
    public List<Object> getIEdits() {
        return iEdits;
    }

    @JsonProperty("i_edits")
    public void setIEdits(List<Object> iEdits) {
        this.iEdits = iEdits;
    }

    @JsonProperty("s_edits")
    public List<Object> getSEdits() {
        return sEdits;
    }

    @JsonProperty("s_edits")
    public void setSEdits(List<Object> sEdits) {
        this.sEdits = sEdits;
    }

    @JsonProperty("t")
    public Long getT() {
        return t;
    }

    @JsonProperty("t")
    public void setT(Long t) {
        this.t = t;
    }

    @JsonProperty("default_anonymity")
    public String getDefaultAnonymity() {
        return defaultAnonymity;
    }

    @JsonProperty("default_anonymity")
    public void setDefaultAnonymity(String defaultAnonymity) {
        this.defaultAnonymity = defaultAnonymity;
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
