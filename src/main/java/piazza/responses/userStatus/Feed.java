package piazza.responses.userStatus;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "fol",
        "m",
        "rq",
        "id",
        "unique_views",
        "score",
        "is_new",
        "bucket_name",
        "bucket_order",
        "folders",
        "nr",
        "main_version",
        "request_instructor",
        "log",
        "subject",
        "no_answer_followup",
        "has_s",
        "num_favorites",
        "type",
        "tags",
        "content_snipet",
        "view_adjust",
        "no_answer",
        "modified",
        "updated",
        "status"
})
public class Feed {

    @JsonProperty("fol")
    private String fol;
    @JsonProperty("m")
    private Long m;
    @JsonProperty("rq")
    private Long rq;
    @JsonProperty("id")
    private String id;
    @JsonProperty("unique_views")
    private Long uniqueViews;
    @JsonProperty("score")
    private Float score;
    @JsonProperty("is_new")
    private Boolean isNew;
    @JsonProperty("bucket_name")
    private String bucketName;
    @JsonProperty("bucket_order")
    private Long bucketOrder;
    @JsonProperty("folders")
    private List<String> folders = null;
    @JsonProperty("nr")
    private Long nr;
    @JsonProperty("main_version")
    private Long mainVersion;
    @JsonProperty("request_instructor")
    private Long requestInstructor;
    @JsonProperty("log")
    private List<Log> log = null;
    @JsonProperty("subject")
    private String subject;
    @JsonProperty("no_answer_followup")
    private Long noAnswerFollowup;
    @JsonProperty("has_s")
    private Boolean hasS;
    @JsonProperty("num_favorites")
    private Long numFavorites;
    @JsonProperty("type")
    private String type;
    @JsonProperty("tags")
    private List<String> tags = null;
    @JsonProperty("content_snipet")
    private String contentSnipet;
    @JsonProperty("view_adjust")
    private Long viewAdjust;
    @JsonProperty("no_answer")
    private Long noAnswer;
    @JsonProperty("modified")
    private String modified;
    @JsonProperty("updated")
    private String updated;
    @JsonProperty("status")
    private String status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("fol")
    public String getFol() {
        return fol;
    }

    @JsonProperty("fol")
    public void setFol(String fol) {
        this.fol = fol;
    }

    @JsonProperty("m")
    public Long getM() {
        return m;
    }

    @JsonProperty("m")
    public void setM(Long m) {
        this.m = m;
    }

    @JsonProperty("rq")
    public Long getRq() {
        return rq;
    }

    @JsonProperty("rq")
    public void setRq(Long rq) {
        this.rq = rq;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("unique_views")
    public Long getUniqueViews() {
        return uniqueViews;
    }

    @JsonProperty("unique_views")
    public void setUniqueViews(Long uniqueViews) {
        this.uniqueViews = uniqueViews;
    }

    @JsonProperty("score")
    public Float getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(Float score) {
        this.score = score;
    }

    @JsonProperty("is_new")
    public Boolean getIsNew() {
        return isNew;
    }

    @JsonProperty("is_new")
    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    @JsonProperty("bucket_name")
    public String getBucketName() {
        return bucketName;
    }

    @JsonProperty("bucket_name")
    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    @JsonProperty("bucket_order")
    public Long getBucketOrder() {
        return bucketOrder;
    }

    @JsonProperty("bucket_order")
    public void setBucketOrder(Long bucketOrder) {
        this.bucketOrder = bucketOrder;
    }

    @JsonProperty("folders")
    public List<String> getFolders() {
        return folders;
    }

    @JsonProperty("folders")
    public void setFolders(List<String> folders) {
        this.folders = folders;
    }

    @JsonProperty("nr")
    public Long getNr() {
        return nr;
    }

    @JsonProperty("nr")
    public void setNr(Long nr) {
        this.nr = nr;
    }

    @JsonProperty("main_version")
    public Long getMainVersion() {
        return mainVersion;
    }

    @JsonProperty("main_version")
    public void setMainVersion(Long mainVersion) {
        this.mainVersion = mainVersion;
    }

    @JsonProperty("request_instructor")
    public Long getRequestInstructor() {
        return requestInstructor;
    }

    @JsonProperty("request_instructor")
    public void setRequestInstructor(Long requestInstructor) {
        this.requestInstructor = requestInstructor;
    }

    @JsonProperty("log")
    public List<Log> getLog() {
        return log;
    }

    @JsonProperty("log")
    public void setLog(List<Log> log) {
        this.log = log;
    }

    @JsonProperty("subject")
    public String getSubject() {
        return subject;
    }

    @JsonProperty("subject")
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @JsonProperty("no_answer_followup")
    public Long getNoAnswerFollowup() {
        return noAnswerFollowup;
    }

    @JsonProperty("no_answer_followup")
    public void setNoAnswerFollowup(Long noAnswerFollowup) {
        this.noAnswerFollowup = noAnswerFollowup;
    }

    @JsonProperty("has_s")
    public Boolean getHasS() {
        return hasS;
    }

    @JsonProperty("has_s")
    public void setHasS(Boolean hasS) {
        this.hasS = hasS;
    }

    @JsonProperty("num_favorites")
    public Long getNumFavorites() {
        return numFavorites;
    }

    @JsonProperty("num_favorites")
    public void setNumFavorites(Long numFavorites) {
        this.numFavorites = numFavorites;
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

    @JsonProperty("content_snipet")
    public String getContentSnipet() {
        return contentSnipet;
    }

    @JsonProperty("content_snipet")
    public void setContentSnipet(String contentSnipet) {
        this.contentSnipet = contentSnipet;
    }

    @JsonProperty("view_adjust")
    public Long getViewAdjust() {
        return viewAdjust;
    }

    @JsonProperty("view_adjust")
    public void setViewAdjust(Long viewAdjust) {
        this.viewAdjust = viewAdjust;
    }

    @JsonProperty("no_answer")
    public Long getNoAnswer() {
        return noAnswer;
    }

    @JsonProperty("no_answer")
    public void setNoAnswer(Long noAnswer) {
        this.noAnswer = noAnswer;
    }

    @JsonProperty("modified")
    public String getModified() {
        return modified;
    }

    @JsonProperty("modified")
    public void setModified(String modified) {
        this.modified = modified;
    }

    @JsonProperty("updated")
    public String getUpdated() {
        return updated;
    }

    @JsonProperty("updated")
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
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
