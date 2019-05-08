package piazza.responses.userStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "more",
        "last_networks",
        "drafts",
        "sort",
        "avg_cnt",
        "users",
        "tags",
        "feed",
        "no_open_teammate_search",
        "avg",
        "t",
        "notification_subjects",
        "token_data",
        "draft",
        "users_7",
        "notifications",
        "hof"
})
public class FeedPrefetch {

    @JsonProperty("more")
    private Boolean more;
    @JsonProperty("last_networks")
    private List<String> lastNetworks = null;
    @JsonProperty("drafts")
    private Map<String, Object> drafts;
    @JsonProperty("sort")
    private String sort;
    @JsonProperty("avg_cnt")
    private Object avgCnt;
    @JsonProperty("users")
    private Long users;
    @JsonProperty("tags")
    private Tags tags;
    @JsonProperty("feed")
    private List<Feed> feed = null;
    @JsonProperty("no_open_teammate_search")
    private Long noOpenTeammateSearch;
    @JsonProperty("avg")
    private Long avg;
    @JsonProperty("t")
    private Long t;
    @JsonProperty("notification_subjects")
    private NotificationSubjects notificationSubjects;
    @JsonProperty("token_data")
    private TokenData tokenData;
    @JsonProperty("draft")
    private Draft draft;
    @JsonProperty("users_7")
    private Long users7;
    @JsonProperty("notifications")
    private List<Object> notifications = null;
    @JsonProperty("hof")
    private Hof hof;

    @JsonProperty("more")
    public Boolean getMore() {
        return more;
    }

    @JsonProperty("more")
    public void setMore(Boolean more) {
        this.more = more;
    }

    @JsonProperty("last_networks")
    public List<String> getLastNetworks() {
        return lastNetworks;
    }

    @JsonProperty("last_networks")
    public void setLastNetworks(List<String> lastNetworks) {
        this.lastNetworks = lastNetworks;
    }

    @JsonProperty("drafts")
    public Map<String, Object> getDrafts() {
        return drafts;
    }

    @JsonProperty("drafts")
    public void setDrafts(Map<String, Object> drafts) {
        this.drafts = drafts;
    }

    @JsonProperty("sort")
    public String getSort() {
        return sort;
    }

    @JsonProperty("sort")
    public void setSort(String sort) {
        this.sort = sort;
    }

    @JsonProperty("avg_cnt")
    public Object getAvgCnt() {
        return avgCnt;
    }

    @JsonProperty("avg_cnt")
    public void setAvgCnt(Object avgCnt) {
        this.avgCnt = avgCnt;
    }

    @JsonProperty("users")
    public Long getUsers() {
        return users;
    }

    @JsonProperty("users")
    public void setUsers(Long users) {
        this.users = users;
    }

    @JsonProperty("tags")
    public Tags getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(Tags tags) {
        this.tags = tags;
    }

    @JsonProperty("feed")
    public List<Feed> getFeed() {
        return feed;
    }

    @JsonProperty("feed")
    public void setFeed(List<Feed> feed) {
        this.feed = feed;
    }

    @JsonProperty("no_open_teammate_search")
    public Long getNoOpenTeammateSearch() {
        return noOpenTeammateSearch;
    }

    @JsonProperty("no_open_teammate_search")
    public void setNoOpenTeammateSearch(Long noOpenTeammateSearch) {
        this.noOpenTeammateSearch = noOpenTeammateSearch;
    }

    @JsonProperty("avg")
    public Long getAvg() {
        return avg;
    }

    @JsonProperty("avg")
    public void setAvg(Long avg) {
        this.avg = avg;
    }

    @JsonProperty("t")
    public Long getT() {
        return t;
    }

    @JsonProperty("t")
    public void setT(Long t) {
        this.t = t;
    }

    @JsonProperty("notification_subjects")
    public NotificationSubjects getNotificationSubjects() {
        return notificationSubjects;
    }

    @JsonProperty("notification_subjects")
    public void setNotificationSubjects(NotificationSubjects notificationSubjects) {
        this.notificationSubjects = notificationSubjects;
    }

    @JsonProperty("token_data")
    public TokenData getTokenData() {
        return tokenData;
    }

    @JsonProperty("token_data")
    public void setTokenData(TokenData tokenData) {
        this.tokenData = tokenData;
    }

    @JsonProperty("draft")
    public Draft getDraft() {
        return draft;
    }

    @JsonProperty("draft")
    public void setDraft(Draft draft) {
        this.draft = draft;
    }

    @JsonProperty("users_7")
    public Long getUsers7() {
        return users7;
    }

    @JsonProperty("users_7")
    public void setUsers7(Long users7) {
        this.users7 = users7;
    }

    @JsonProperty("notifications")
    public List<Object> getNotifications() {
        return notifications;
    }

    @JsonProperty("notifications")
    public void setNotifications(List<Object> notifications) {
        this.notifications = notifications;
    }

    @JsonProperty("hof")
    public Hof getHof() {
        return hof;
    }

    @JsonProperty("hof")
    public void setHof(Hof hof) {
        this.hof = hof;
    }

}
