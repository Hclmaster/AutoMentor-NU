package com.nu.automentor.model;

import piazza.responses.contentGet.ContentGetResponse;

import java.util.List;

public class PiazzaResponse {

    private ContentGetResponse post;

    private String cid;

    private String nid;

    private List<String> samplePostIds;

    public ContentGetResponse getPost() {
        return post;
    }

    public void setPost(ContentGetResponse post) {
        this.post = post;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public List<String> getSamplePostIds() {
        return samplePostIds;
    }

    public void setSamplePostIds(List<String> samplePostIds) {
        this.samplePostIds = samplePostIds;
    }
}
