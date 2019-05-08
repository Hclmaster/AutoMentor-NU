package piazza.responses.userStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "poll_close_date_menu",
        "new_post_anonymity",
        "member_names",
        "input_poll_choice",
        "post_summary",
        "input_poll_explanation",
        "poll_member_names"
})
public class Txt {

    @JsonProperty("poll_close_date_menu")
    private String pollCloseDateMenu;
    @JsonProperty("new_post_anonymity")
    private String newPostAnonymity;
    @JsonProperty("member_names")
    private String memberNames;
    @JsonProperty("input_poll_choice")
    private String inputPollChoice;
    @JsonProperty("post_summary")
    private String postSummary;
    @JsonProperty("input_poll_explanation")
    private String inputPollExplanation;
    @JsonProperty("poll_member_names")
    private String pollMemberNames;

    @JsonProperty("poll_close_date_menu")
    public String getPollCloseDateMenu() {
        return pollCloseDateMenu;
    }

    @JsonProperty("poll_close_date_menu")
    public void setPollCloseDateMenu(String pollCloseDateMenu) {
        this.pollCloseDateMenu = pollCloseDateMenu;
    }

    @JsonProperty("new_post_anonymity")
    public String getNewPostAnonymity() {
        return newPostAnonymity;
    }

    @JsonProperty("new_post_anonymity")
    public void setNewPostAnonymity(String newPostAnonymity) {
        this.newPostAnonymity = newPostAnonymity;
    }

    @JsonProperty("member_names")
    public String getMemberNames() {
        return memberNames;
    }

    @JsonProperty("member_names")
    public void setMemberNames(String memberNames) {
        this.memberNames = memberNames;
    }

    @JsonProperty("input_poll_choice")
    public String getInputPollChoice() {
        return inputPollChoice;
    }

    @JsonProperty("input_poll_choice")
    public void setInputPollChoice(String inputPollChoice) {
        this.inputPollChoice = inputPollChoice;
    }

    @JsonProperty("post_summary")
    public String getPostSummary() {
        return postSummary;
    }

    @JsonProperty("post_summary")
    public void setPostSummary(String postSummary) {
        this.postSummary = postSummary;
    }

    @JsonProperty("input_poll_explanation")
    public String getInputPollExplanation() {
        return inputPollExplanation;
    }

    @JsonProperty("input_poll_explanation")
    public void setInputPollExplanation(String inputPollExplanation) {
        this.inputPollExplanation = inputPollExplanation;
    }

    @JsonProperty("poll_member_names")
    public String getPollMemberNames() {
        return pollMemberNames;
    }

    @JsonProperty("poll_member_names")
    public void setPollMemberNames(String pollMemberNames) {
        this.pollMemberNames = pollMemberNames;
    }

}
