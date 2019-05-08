package piazza.requests.userLogin;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserLoginRequest {

    @JsonProperty("method")
    private final String method = "user.login";

    @JsonProperty("params")
    private final UserLoginParams params;

    public UserLoginRequest(String email, String pass) {
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

