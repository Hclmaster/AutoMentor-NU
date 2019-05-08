package piazza.responses.userStatus;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "member_answer_create",
        "new_post",
        "expert_answer_endorse",
        "can_post_anonymous_members",
        "question_edit",
        "member_answer_endorse",
        "new_followup",
        "member_answer_edit"
})
public class Student {

    @JsonProperty("member_answer_create")
    private Boolean memberAnswerCreate;
    @JsonProperty("new_post")
    private Boolean newPost;
    @JsonProperty("expert_answer_endorse")
    private Boolean expertAnswerEndorse;
    @JsonProperty("can_post_anonymous_members")
    private Boolean canPostAnonymousMembers;
    @JsonProperty("question_edit")
    private Boolean questionEdit;
    @JsonProperty("member_answer_endorse")
    private Boolean memberAnswerEndorse;
    @JsonProperty("new_followup")
    private Boolean newFollowup;
    @JsonProperty("member_answer_edit")
    private Boolean memberAnswerEdit;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("member_answer_create")
    public Boolean getMemberAnswerCreate() {
        return memberAnswerCreate;
    }

    @JsonProperty("member_answer_create")
    public void setMemberAnswerCreate(Boolean memberAnswerCreate) {
        this.memberAnswerCreate = memberAnswerCreate;
    }

    @JsonProperty("new_post")
    public Boolean getNewPost() {
        return newPost;
    }

    @JsonProperty("new_post")
    public void setNewPost(Boolean newPost) {
        this.newPost = newPost;
    }

    @JsonProperty("expert_answer_endorse")
    public Boolean getExpertAnswerEndorse() {
        return expertAnswerEndorse;
    }

    @JsonProperty("expert_answer_endorse")
    public void setExpertAnswerEndorse(Boolean expertAnswerEndorse) {
        this.expertAnswerEndorse = expertAnswerEndorse;
    }

    @JsonProperty("can_post_anonymous_members")
    public Boolean getCanPostAnonymousMembers() {
        return canPostAnonymousMembers;
    }

    @JsonProperty("can_post_anonymous_members")
    public void setCanPostAnonymousMembers(Boolean canPostAnonymousMembers) {
        this.canPostAnonymousMembers = canPostAnonymousMembers;
    }

    @JsonProperty("question_edit")
    public Boolean getQuestionEdit() {
        return questionEdit;
    }

    @JsonProperty("question_edit")
    public void setQuestionEdit(Boolean questionEdit) {
        this.questionEdit = questionEdit;
    }

    @JsonProperty("member_answer_endorse")
    public Boolean getMemberAnswerEndorse() {
        return memberAnswerEndorse;
    }

    @JsonProperty("member_answer_endorse")
    public void setMemberAnswerEndorse(Boolean memberAnswerEndorse) {
        this.memberAnswerEndorse = memberAnswerEndorse;
    }

    @JsonProperty("new_followup")
    public Boolean getNewFollowup() {
        return newFollowup;
    }

    @JsonProperty("new_followup")
    public void setNewFollowup(Boolean newFollowup) {
        this.newFollowup = newFollowup;
    }

    @JsonProperty("member_answer_edit")
    public Boolean getMemberAnswerEdit() {
        return memberAnswerEdit;
    }

    @JsonProperty("member_answer_edit")
    public void setMemberAnswerEdit(Boolean memberAnswerEdit) {
        this.memberAnswerEdit = memberAnswerEdit;
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
