package piazza.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContentGetRequest {

    @JsonProperty("method")
    private final String method;
    @JsonProperty("params")
    private final ContentGetParams params;

    public ContentGetRequest(String method, String cid, String nid) {
        this.method = method;
        this.params = new ContentGetParams(cid, nid);
    }

    @JsonProperty("method")
    public String getMethod() {
        return method;
    }

    @JsonProperty("params")
    public ContentGetParams getParams() {
        return params;
    }

}

