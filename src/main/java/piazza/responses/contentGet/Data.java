package piazza.responses.contentGet;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "embed_links"
})
public class Data {

    @JsonProperty("embed_links")
    private List<Object> embedLinks = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("embed_links")
    public List<Object> getEmbedLinks() {
        return embedLinks;
    }

    @JsonProperty("embed_links")
    public void setEmbedLinks(List<Object> embedLinks) {
        this.embedLinks = embedLinks;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
