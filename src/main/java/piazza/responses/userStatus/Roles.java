package piazza.responses.userStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "professor",
        "instructor",
        "student",
        "admin",
        "ta"
})
public class Roles {

    @JsonProperty("professor")
    private Professor professor;
    @JsonProperty("instructor")
    private Instructor instructor;
    @JsonProperty("student")
    private Student student;
    @JsonProperty("admin")
    private Admin admin;
    @JsonProperty("ta")
    private Ta ta;

    @JsonProperty("professor")
    public Professor getProfessor() {
        return professor;
    }

    @JsonProperty("professor")
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @JsonProperty("instructor")
    public Instructor getInstructor() {
        return instructor;
    }

    @JsonProperty("instructor")
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @JsonProperty("student")
    public Student getStudent() {
        return student;
    }

    @JsonProperty("student")
    public void setStudent(Student student) {
        this.student = student;
    }

    @JsonProperty("admin")
    public Admin getAdmin() {
        return admin;
    }

    @JsonProperty("admin")
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @JsonProperty("ta")
    public Ta getTa() {
        return ta;
    }

    @JsonProperty("ta")
    public void setTa(Ta ta) {
        this.ta = ta;
    }

}
