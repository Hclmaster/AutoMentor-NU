package piazza;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

class UserLoginRequest {

    @JsonProperty("method")
    private final String method;

    @JsonProperty("params")
    private final UserLoginParams params;

    UserLoginRequest(String method, String email, String pass) {
        this.method = method;
        this.params = new UserLoginParams(email, pass);
    }

    @JsonProperty("method")
    public String getMethod() {
        return method;
    }

    @JsonProperty("params")
    public UserLoginParams getParams() {
        return params;
    }

}

@JsonInclude(JsonInclude.Include.NON_NULL)
class UserLoginParams {

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