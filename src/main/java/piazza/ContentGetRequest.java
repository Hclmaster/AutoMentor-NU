package piazza;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

class ContentGetRequest {

    @JsonProperty("method")
    private final String method;
    @JsonProperty("params")
    private final ContentGetParams params;

    ContentGetRequest(String method, String cid, String nid) {
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

@JsonInclude(JsonInclude.Include.NON_NULL)
class ContentGetParams {
    @JsonProperty("cid")
    private final String cid;
    @JsonProperty("nid")
    private final String nid;

    ContentGetParams(String cid, String nid) {
        this.cid = cid;
        this.nid = nid;
    }

    @JsonProperty("cid")
    public String getCid() {
        return cid;
    }

    @JsonProperty("nid")
    public String getNid() {
        return nid;
    }
}