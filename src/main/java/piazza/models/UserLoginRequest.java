package piazza.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserLoginRequest {

    @JsonProperty("method")
    private final String method;

    @JsonProperty("params")
    private final UserLoginParams params;

    public UserLoginRequest(String method, String email, String pass) {
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

