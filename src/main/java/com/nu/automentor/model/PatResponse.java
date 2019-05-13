package com.nu.automentor.model;

public class PatResponse {
    private String response;
    private String pattern;

    public PatResponse() {
    }

    public PatResponse(String response, String pattern) {
        this.response = response;
        this.pattern = pattern;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
