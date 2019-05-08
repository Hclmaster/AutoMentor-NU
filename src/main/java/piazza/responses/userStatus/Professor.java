package piazza.responses.userStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "new_post",
        "expert_answer_endorse",
        "manage_group_info",
        "question_edit",
        "member_answer_endorse",
        "member_answer_edit",
        "manage_groups",
        "expert_answer_edit",
        "followup_edit",
        "admin_roster",
        "manage_folders",
        "manage_resources",
        "expert_answer_create",
        "member_roster",
        "new_followup",
        "question_delete"
})
public class Professor {

    @JsonProperty("new_post")
    private Boolean newPost;
    @JsonProperty("expert_answer_endorse")
    private Boolean expertAnswerEndorse;
    @JsonProperty("manage_group_info")
    private Boolean manageGroupInfo;
    @JsonProperty("question_edit")
    private Boolean questionEdit;
    @JsonProperty("member_answer_endorse")
    private Boolean memberAnswerEndorse;
    @JsonProperty("member_answer_edit")
    private Boolean memberAnswerEdit;
    @JsonProperty("manage_groups")
    private Boolean manageGroups;
    @JsonProperty("expert_answer_edit")
    private Boolean expertAnswerEdit;
    @JsonProperty("followup_edit")
    private Boolean followupEdit;
    @JsonProperty("admin_roster")
    private Boolean adminRoster;
    @JsonProperty("manage_folders")
    private Boolean manageFolders;
    @JsonProperty("manage_resources")
    private Boolean manageResources;
    @JsonProperty("expert_answer_create")
    private Boolean expertAnswerCreate;
    @JsonProperty("member_roster")
    private Boolean memberRoster;
    @JsonProperty("new_followup")
    private Boolean newFollowup;
    @JsonProperty("question_delete")
    private Boolean questionDelete;

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

    @JsonProperty("manage_group_info")
    public Boolean getManageGroupInfo() {
        return manageGroupInfo;
    }

    @JsonProperty("manage_group_info")
    public void setManageGroupInfo(Boolean manageGroupInfo) {
        this.manageGroupInfo = manageGroupInfo;
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

    @JsonProperty("member_answer_edit")
    public Boolean getMemberAnswerEdit() {
        return memberAnswerEdit;
    }

    @JsonProperty("member_answer_edit")
    public void setMemberAnswerEdit(Boolean memberAnswerEdit) {
        this.memberAnswerEdit = memberAnswerEdit;
    }

    @JsonProperty("manage_groups")
    public Boolean getManageGroups() {
        return manageGroups;
    }

    @JsonProperty("manage_groups")
    public void setManageGroups(Boolean manageGroups) {
        this.manageGroups = manageGroups;
    }

    @JsonProperty("expert_answer_edit")
    public Boolean getExpertAnswerEdit() {
        return expertAnswerEdit;
    }

    @JsonProperty("expert_answer_edit")
    public void setExpertAnswerEdit(Boolean expertAnswerEdit) {
        this.expertAnswerEdit = expertAnswerEdit;
    }

    @JsonProperty("followup_edit")
    public Boolean getFollowupEdit() {
        return followupEdit;
    }

    @JsonProperty("followup_edit")
    public void setFollowupEdit(Boolean followupEdit) {
        this.followupEdit = followupEdit;
    }

    @JsonProperty("admin_roster")
    public Boolean getAdminRoster() {
        return adminRoster;
    }

    @JsonProperty("admin_roster")
    public void setAdminRoster(Boolean adminRoster) {
        this.adminRoster = adminRoster;
    }

    @JsonProperty("manage_folders")
    public Boolean getManageFolders() {
        return manageFolders;
    }

    @JsonProperty("manage_folders")
    public void setManageFolders(Boolean manageFolders) {
        this.manageFolders = manageFolders;
    }

    @JsonProperty("manage_resources")
    public Boolean getManageResources() {
        return manageResources;
    }

    @JsonProperty("manage_resources")
    public void setManageResources(Boolean manageResources) {
        this.manageResources = manageResources;
    }

    @JsonProperty("expert_answer_create")
    public Boolean getExpertAnswerCreate() {
        return expertAnswerCreate;
    }

    @JsonProperty("expert_answer_create")
    public void setExpertAnswerCreate(Boolean expertAnswerCreate) {
        this.expertAnswerCreate = expertAnswerCreate;
    }

    @JsonProperty("member_roster")
    public Boolean getMemberRoster() {
        return memberRoster;
    }

    @JsonProperty("member_roster")
    public void setMemberRoster(Boolean memberRoster) {
        this.memberRoster = memberRoster;
    }

    @JsonProperty("new_followup")
    public Boolean getNewFollowup() {
        return newFollowup;
    }

    @JsonProperty("new_followup")
    public void setNewFollowup(Boolean newFollowup) {
        this.newFollowup = newFollowup;
    }

    @JsonProperty("question_delete")
    public Boolean getQuestionDelete() {
        return questionDelete;
    }

    @JsonProperty("question_delete")
    public void setQuestionDelete(Boolean questionDelete) {
        this.questionDelete = questionDelete;
    }

}
