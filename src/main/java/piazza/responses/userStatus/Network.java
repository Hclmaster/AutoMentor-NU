package piazza.responses.userStatus;

import com.fasterxml.jackson.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "end_date",
        "syllabus",
        "folders",
        "created_at",
        "private_posts",
        "taxonomy",
        "type",
        "my_name",
        "total_content_stud",
        "school_short",
        "school_id",
        "school",
        "anonymity",
        "term",
        "id",
        "department",
        "school_ext",
        "start_date",
        "office_hours",
        "course_number",
        "profs",
        "topics",
        "enrollment",
        "prof_hash",
        "isOpen",
        "school_emails",
        "short_number",
        "user_count",
        "name",
        "general_information",
        "auto_join",
        "creator_name",
        "total_content_prof",
        "config",
        "course_description",
        "status",
        "special_tags"
})
public class Network {

    @JsonProperty("end_date")
    private Object endDate;
    @JsonProperty("syllabus")
    private String syllabus;
    @JsonProperty("folders")
    private List<String> folders = null;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("private_posts")
    private String privatePosts;
    @JsonProperty("taxonomy")
    private List<Object> taxonomy = null;
    @JsonProperty("type")
    private String type;
    @JsonProperty("my_name")
    private String myName;
    @JsonProperty("total_content_stud")
    private Long totalContentStud;
    @JsonProperty("school_short")
    private String schoolShort;
    @JsonProperty("school_id")
    private String schoolId;
    @JsonProperty("school")
    private String school;
    @JsonProperty("anonymity")
    private String anonymity;
    @JsonProperty("term")
    private String term;
    @JsonProperty("id")
    private String id;
    @JsonProperty("department")
    private String department;
    @JsonProperty("school_ext")
    private String schoolExt;
    @JsonProperty("start_date")
    private Date startDate;
    @JsonProperty("office_hours")
    private Map<String, Object> officeHours;
    @JsonProperty("course_number")
    private String courseNumber;
    @JsonProperty("profs")
    private List<Prof> profs = null;
    @JsonProperty("topics")
    private List<String> topics = null;
    @JsonProperty("enrollment")
    private String enrollment;
    @JsonProperty("prof_hash")
    private Map<String, Long> profHash;
    @JsonProperty("isOpen")
    private Boolean isOpen;
    @JsonProperty("school_emails")
    private String schoolEmails;
    @JsonProperty("short_number")
    private String shortNumber;
    @JsonProperty("user_count")
    private Long userCount;
    @JsonProperty("name")
    private String name;
    @JsonProperty("general_information")
    private List<Object> generalInformation = null;
    @JsonProperty("auto_join")
    private String autoJoin;
    @JsonProperty("creator_name")
    private String creatorName;
    @JsonProperty("total_content_prof")
    private Long totalContentProf;
    @JsonProperty("config")
    private Config config;
    @JsonProperty("course_description")
    private String courseDescription;
    @JsonProperty("status")
    private String status;
    @JsonProperty("special_tags")
    private List<SpecialTag> specialTags = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("end_date")
    public Object getEndDate() {
        return endDate;
    }

    @JsonProperty("end_date")
    public void setEndDate(Object endDate) {
        this.endDate = endDate;
    }

    @JsonProperty("syllabus")
    public String getSyllabus() {
        return syllabus;
    }

    @JsonProperty("syllabus")
    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    @JsonProperty("folders")
    public List<String> getFolders() {
        return folders;
    }

    @JsonProperty("folders")
    public void setFolders(List<String> folders) {
        this.folders = folders;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("private_posts")
    public String getPrivatePosts() {
        return privatePosts;
    }

    @JsonProperty("private_posts")
    public void setPrivatePosts(String privatePosts) {
        this.privatePosts = privatePosts;
    }

    @JsonProperty("taxonomy")
    public List<Object> getTaxonomy() {
        return taxonomy;
    }

    @JsonProperty("taxonomy")
    public void setTaxonomy(List<Object> taxonomy) {
        this.taxonomy = taxonomy;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("my_name")
    public String getMyName() {
        return myName;
    }

    @JsonProperty("my_name")
    public void setMyName(String myName) {
        this.myName = myName;
    }

    @JsonProperty("total_content_stud")
    public Long getTotalContentStud() {
        return totalContentStud;
    }

    @JsonProperty("total_content_stud")
    public void setTotalContentStud(Long totalContentStud) {
        this.totalContentStud = totalContentStud;
    }

    @JsonProperty("school_short")
    public String getSchoolShort() {
        return schoolShort;
    }

    @JsonProperty("school_short")
    public void setSchoolShort(String schoolShort) {
        this.schoolShort = schoolShort;
    }

    @JsonProperty("school_id")
    public String getSchoolId() {
        return schoolId;
    }

    @JsonProperty("school_id")
    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    @JsonProperty("school")
    public String getSchool() {
        return school;
    }

    @JsonProperty("school")
    public void setSchool(String school) {
        this.school = school;
    }

    @JsonProperty("anonymity")
    public String getAnonymity() {
        return anonymity;
    }

    @JsonProperty("anonymity")
    public void setAnonymity(String anonymity) {
        this.anonymity = anonymity;
    }

    @JsonProperty("term")
    public String getTerm() {
        return term;
    }

    @JsonProperty("term")
    public void setTerm(String term) {
        this.term = term;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("department")
    public String getDepartment() {
        return department;
    }

    @JsonProperty("department")
    public void setDepartment(String department) {
        this.department = department;
    }

    @JsonProperty("school_ext")
    public String getSchoolExt() {
        return schoolExt;
    }

    @JsonProperty("school_ext")
    public void setSchoolExt(String schoolExt) {
        this.schoolExt = schoolExt;
    }

    @JsonProperty("start_date")
    public Date getStartDate() {
        return startDate;
    }

    @JsonProperty("start_date")
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("office_hours")
    public Map<String, Object> getOfficeHours() {
        return officeHours;
    }

    @JsonProperty("office_hours")
    public void setOfficeHours(Map<String, Object> officeHours) {
        this.officeHours = officeHours;
    }

    @JsonProperty("course_number")
    public String getCourseNumber() {
        return courseNumber;
    }

    @JsonProperty("course_number")
    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    @JsonProperty("profs")
    public List<Prof> getProfs() {
        return profs;
    }

    @JsonProperty("profs")
    public void setProfs(List<Prof> profs) {
        this.profs = profs;
    }

    @JsonProperty("topics")
    public List<String> getTopics() {
        return topics;
    }

    @JsonProperty("topics")
    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    @JsonProperty("enrollment")
    public String getEnrollment() {
        return enrollment;
    }

    @JsonProperty("enrollment")
    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    @JsonProperty("prof_hash")
    public Map<String, Long> getProfHash() {
        return profHash;
    }

    @JsonProperty("prof_hash")
    public void setProfHash(Map<String, Long> profHash) {
        this.profHash = profHash;
    }

    @JsonProperty("isOpen")
    public Boolean getIsOpen() {
        return isOpen;
    }

    @JsonProperty("isOpen")
    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    @JsonProperty("school_emails")
    public String getSchoolEmails() {
        return schoolEmails;
    }

    @JsonProperty("school_emails")
    public void setSchoolEmails(String schoolEmails) {
        this.schoolEmails = schoolEmails;
    }

    @JsonProperty("short_number")
    public String getShortNumber() {
        return shortNumber;
    }

    @JsonProperty("short_number")
    public void setShortNumber(String shortNumber) {
        this.shortNumber = shortNumber;
    }

    @JsonProperty("user_count")
    public Long getUserCount() {
        return userCount;
    }

    @JsonProperty("user_count")
    public void setUserCount(Long userCount) {
        this.userCount = userCount;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("general_information")
    public List<Object> getGeneralInformation() {
        return generalInformation;
    }

    @JsonProperty("general_information")
    public void setGeneralInformation(List<Object> generalInformation) {
        this.generalInformation = generalInformation;
    }

    @JsonProperty("auto_join")
    public String getAutoJoin() {
        return autoJoin;
    }

    @JsonProperty("auto_join")
    public void setAutoJoin(String autoJoin) {
        this.autoJoin = autoJoin;
    }

    @JsonProperty("creator_name")
    public String getCreatorName() {
        return creatorName;
    }

    @JsonProperty("creator_name")
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    @JsonProperty("total_content_prof")
    public Long getTotalContentProf() {
        return totalContentProf;
    }

    @JsonProperty("total_content_prof")
    public void setTotalContentProf(Long totalContentProf) {
        this.totalContentProf = totalContentProf;
    }

    @JsonProperty("config")
    public Config getConfig() {
        return config;
    }

    @JsonProperty("config")
    public void setConfig(Config config) {
        this.config = config;
    }

    @JsonProperty("course_description")
    public String getCourseDescription() {
        return courseDescription;
    }

    @JsonProperty("course_description")
    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("special_tags")
    public List<SpecialTag> getSpecialTags() {
        return specialTags;
    }

    @JsonProperty("special_tags")
    public void setSpecialTags(List<SpecialTag> specialTags) {
        this.specialTags = specialTags;
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
