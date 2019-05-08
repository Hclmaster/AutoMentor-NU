package piazza.responses.userStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "selections_allowed_more",
        "post_type_note",
        "poll_anonymity_students",
        "publish_to_individuals",
        "revotes_no",
        "publish_now",
        "post_type_question",
        "show_poll_results_after_poll_closes",
        "revotes_yes",
        "individual_members",
        "poll_close_date_after",
        "poll_anonymity_nobody",
        "poll_anonymity_everyone",
        "publish_later",
        "show_poll_results_after_member_votes",
        "show_poll_results_keep_private",
        "poll_close_date_never",
        "selections_allowed_one",
        "show_poll_results_before_member_votes",
        "entire_group"
})
public class Btn {

    @JsonProperty("selections_allowed_more")
    private Boolean selectionsAllowedMore;
    @JsonProperty("post_type_note")
    private Boolean postTypeNote;
    @JsonProperty("poll_anonymity_students")
    private Boolean pollAnonymityStudents;
    @JsonProperty("publish_to_individuals")
    private Boolean publishToIndividuals;
    @JsonProperty("revotes_no")
    private Boolean revotesNo;
    @JsonProperty("publish_now")
    private Boolean publishNow;
    @JsonProperty("post_type_question")
    private Boolean postTypeQuestion;
    @JsonProperty("show_poll_results_after_poll_closes")
    private Boolean showPollResultsAfterPollCloses;
    @JsonProperty("revotes_yes")
    private Boolean revotesYes;
    @JsonProperty("individual_members")
    private Boolean individualMembers;
    @JsonProperty("poll_close_date_after")
    private Boolean pollCloseDateAfter;
    @JsonProperty("poll_anonymity_nobody")
    private Boolean pollAnonymityNobody;
    @JsonProperty("poll_anonymity_everyone")
    private Boolean pollAnonymityEveryone;
    @JsonProperty("publish_later")
    private Boolean publishLater;
    @JsonProperty("show_poll_results_after_member_votes")
    private Boolean showPollResultsAfterMemberVotes;
    @JsonProperty("show_poll_results_keep_private")
    private Boolean showPollResultsKeepPrivate;
    @JsonProperty("poll_close_date_never")
    private Boolean pollCloseDateNever;
    @JsonProperty("selections_allowed_one")
    private Boolean selectionsAllowedOne;
    @JsonProperty("show_poll_results_before_member_votes")
    private Boolean showPollResultsBeforeMemberVotes;
    @JsonProperty("entire_group")
    private Boolean entireGroup;

    @JsonProperty("selections_allowed_more")
    public Boolean getSelectionsAllowedMore() {
        return selectionsAllowedMore;
    }

    @JsonProperty("selections_allowed_more")
    public void setSelectionsAllowedMore(Boolean selectionsAllowedMore) {
        this.selectionsAllowedMore = selectionsAllowedMore;
    }

    @JsonProperty("post_type_note")
    public Boolean getPostTypeNote() {
        return postTypeNote;
    }

    @JsonProperty("post_type_note")
    public void setPostTypeNote(Boolean postTypeNote) {
        this.postTypeNote = postTypeNote;
    }

    @JsonProperty("poll_anonymity_students")
    public Boolean getPollAnonymityStudents() {
        return pollAnonymityStudents;
    }

    @JsonProperty("poll_anonymity_students")
    public void setPollAnonymityStudents(Boolean pollAnonymityStudents) {
        this.pollAnonymityStudents = pollAnonymityStudents;
    }

    @JsonProperty("publish_to_individuals")
    public Boolean getPublishToIndividuals() {
        return publishToIndividuals;
    }

    @JsonProperty("publish_to_individuals")
    public void setPublishToIndividuals(Boolean publishToIndividuals) {
        this.publishToIndividuals = publishToIndividuals;
    }

    @JsonProperty("revotes_no")
    public Boolean getRevotesNo() {
        return revotesNo;
    }

    @JsonProperty("revotes_no")
    public void setRevotesNo(Boolean revotesNo) {
        this.revotesNo = revotesNo;
    }

    @JsonProperty("publish_now")
    public Boolean getPublishNow() {
        return publishNow;
    }

    @JsonProperty("publish_now")
    public void setPublishNow(Boolean publishNow) {
        this.publishNow = publishNow;
    }

    @JsonProperty("post_type_question")
    public Boolean getPostTypeQuestion() {
        return postTypeQuestion;
    }

    @JsonProperty("post_type_question")
    public void setPostTypeQuestion(Boolean postTypeQuestion) {
        this.postTypeQuestion = postTypeQuestion;
    }

    @JsonProperty("show_poll_results_after_poll_closes")
    public Boolean getShowPollResultsAfterPollCloses() {
        return showPollResultsAfterPollCloses;
    }

    @JsonProperty("show_poll_results_after_poll_closes")
    public void setShowPollResultsAfterPollCloses(Boolean showPollResultsAfterPollCloses) {
        this.showPollResultsAfterPollCloses = showPollResultsAfterPollCloses;
    }

    @JsonProperty("revotes_yes")
    public Boolean getRevotesYes() {
        return revotesYes;
    }

    @JsonProperty("revotes_yes")
    public void setRevotesYes(Boolean revotesYes) {
        this.revotesYes = revotesYes;
    }

    @JsonProperty("individual_members")
    public Boolean getIndividualMembers() {
        return individualMembers;
    }

    @JsonProperty("individual_members")
    public void setIndividualMembers(Boolean individualMembers) {
        this.individualMembers = individualMembers;
    }

    @JsonProperty("poll_close_date_after")
    public Boolean getPollCloseDateAfter() {
        return pollCloseDateAfter;
    }

    @JsonProperty("poll_close_date_after")
    public void setPollCloseDateAfter(Boolean pollCloseDateAfter) {
        this.pollCloseDateAfter = pollCloseDateAfter;
    }

    @JsonProperty("poll_anonymity_nobody")
    public Boolean getPollAnonymityNobody() {
        return pollAnonymityNobody;
    }

    @JsonProperty("poll_anonymity_nobody")
    public void setPollAnonymityNobody(Boolean pollAnonymityNobody) {
        this.pollAnonymityNobody = pollAnonymityNobody;
    }

    @JsonProperty("poll_anonymity_everyone")
    public Boolean getPollAnonymityEveryone() {
        return pollAnonymityEveryone;
    }

    @JsonProperty("poll_anonymity_everyone")
    public void setPollAnonymityEveryone(Boolean pollAnonymityEveryone) {
        this.pollAnonymityEveryone = pollAnonymityEveryone;
    }

    @JsonProperty("publish_later")
    public Boolean getPublishLater() {
        return publishLater;
    }

    @JsonProperty("publish_later")
    public void setPublishLater(Boolean publishLater) {
        this.publishLater = publishLater;
    }

    @JsonProperty("show_poll_results_after_member_votes")
    public Boolean getShowPollResultsAfterMemberVotes() {
        return showPollResultsAfterMemberVotes;
    }

    @JsonProperty("show_poll_results_after_member_votes")
    public void setShowPollResultsAfterMemberVotes(Boolean showPollResultsAfterMemberVotes) {
        this.showPollResultsAfterMemberVotes = showPollResultsAfterMemberVotes;
    }

    @JsonProperty("show_poll_results_keep_private")
    public Boolean getShowPollResultsKeepPrivate() {
        return showPollResultsKeepPrivate;
    }

    @JsonProperty("show_poll_results_keep_private")
    public void setShowPollResultsKeepPrivate(Boolean showPollResultsKeepPrivate) {
        this.showPollResultsKeepPrivate = showPollResultsKeepPrivate;
    }

    @JsonProperty("poll_close_date_never")
    public Boolean getPollCloseDateNever() {
        return pollCloseDateNever;
    }

    @JsonProperty("poll_close_date_never")
    public void setPollCloseDateNever(Boolean pollCloseDateNever) {
        this.pollCloseDateNever = pollCloseDateNever;
    }

    @JsonProperty("selections_allowed_one")
    public Boolean getSelectionsAllowedOne() {
        return selectionsAllowedOne;
    }

    @JsonProperty("selections_allowed_one")
    public void setSelectionsAllowedOne(Boolean selectionsAllowedOne) {
        this.selectionsAllowedOne = selectionsAllowedOne;
    }

    @JsonProperty("show_poll_results_before_member_votes")
    public Boolean getShowPollResultsBeforeMemberVotes() {
        return showPollResultsBeforeMemberVotes;
    }

    @JsonProperty("show_poll_results_before_member_votes")
    public void setShowPollResultsBeforeMemberVotes(Boolean showPollResultsBeforeMemberVotes) {
        this.showPollResultsBeforeMemberVotes = showPollResultsBeforeMemberVotes;
    }

    @JsonProperty("entire_group")
    public Boolean getEntireGroup() {
        return entireGroup;
    }

    @JsonProperty("entire_group")
    public void setEntireGroup(Boolean entireGroup) {
        this.entireGroup = entireGroup;
    }

}
