package piazza.responses.userStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "role",
        "name",
        "endorser",
        "admin",
        "photo",
        "id",
        "photo_url",
        "email",
        "us",
        "admin_permission",
        "facebook_id",
        "published"
})
public class Prof {

    @JsonProperty("role")
    private String role;
    @JsonProperty("name")
    private String name;
    @JsonProperty("endorser")
    private Map<String, Long> endorser;
    @JsonProperty("admin")
    private Boolean admin;
    @JsonProperty("photo")
    private Object photo;
    @JsonProperty("id")
    private String id;
    @JsonProperty("photo_url")
    private Object photoUrl;
    @JsonProperty("email")
    private String email;
    @JsonProperty("us")
    private Boolean us;
    @JsonProperty("admin_permission")
    private Long adminPermission;
    @JsonProperty("facebook_id")
    private Object facebookId;
    @JsonProperty("published")
    private Boolean published;

    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("endorser")
    public Map<String, Long> getEndorser() {
        return endorser;
    }

    @JsonProperty("endorser")
    public void setEndorser(Map<String, Long> endorser) {
        this.endorser = endorser;
    }

    @JsonProperty("admin")
    public Boolean getAdmin() {
        return admin;
    }

    @JsonProperty("admin")
    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @JsonProperty("photo")
    public Object getPhoto() {
        return photo;
    }

    @JsonProperty("photo")
    public void setPhoto(Object photo) {
        this.photo = photo;
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

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("us")
    public Boolean getUs() {
        return us;
    }

    @JsonProperty("us")
    public void setUs(Boolean us) {
        this.us = us;
    }

    @JsonProperty("admin_permission")
    public Long getAdminPermission() {
        return adminPermission;
    }

    @JsonProperty("admin_permission")
    public void setAdminPermission(Long adminPermission) {
        this.adminPermission = adminPermission;
    }

    @JsonProperty("facebook_id")
    public Object getFacebookId() {
        return facebookId;
    }

    @JsonProperty("facebook_id")
    public void setFacebookId(Object facebookId) {
        this.facebookId = facebookId;
    }

    @JsonProperty("published")
    public Boolean getPublished() {
        return published;
    }

    @JsonProperty("published")
    public void setPublished(Boolean published) {
        this.published = published;
    }

}
