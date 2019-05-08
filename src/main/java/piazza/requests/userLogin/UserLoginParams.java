package piazza.requests.userLogin;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserLoginParams {

    @JsonProperty("email")
    private final String email;
    @JsonProperty("pass")
    private final String pass;

    UserLoginParams(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("pass")
    public String getPass() {
        return pass;
    }
}
