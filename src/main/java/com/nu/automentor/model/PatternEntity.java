package com.nu.automentor.model;

import net.sf.json.JSONObject;

import java.util.List;

public class PatternEntity {
    private int id;
    private JSONObject patterns;
    private List<String> response;

    public PatternEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JSONObject getPatterns() {
        return patterns;
    }

    public void setPatterns(JSONObject patterns) {
        this.patterns = patterns;
    }

    public List<String> getResponse() {
        return response;
    }

    public void setResponse(List<String> response) {
        this.response = response;
    }
}
