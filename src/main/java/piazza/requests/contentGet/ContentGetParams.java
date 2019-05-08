package piazza.requests.contentGet;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContentGetParams {
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
