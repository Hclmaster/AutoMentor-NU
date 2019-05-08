package piazza.requests.contentGet;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContentGetRequest {

    @JsonProperty("method")
    private final String method = "content.get";
    @JsonProperty("params")
    private final ContentGetParams params;

    public ContentGetRequest(String cid, String nid) {
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

