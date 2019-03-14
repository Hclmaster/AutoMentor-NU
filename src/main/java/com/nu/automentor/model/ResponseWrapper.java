package com.nu.automentor.model;

import org.json.simple.JSONObject;

import java.util.List;

public class ResponseWrapper {
    private StudentEntity student;
    private List<DataEntity> textBlocks;
    private List<String> response;
    private String message;
    private String patternsObj;

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public List<String> getResponse() {
        return response;
    }

    public void setResponse(List<String> response) {
        this.response = response;
    }

    public List<DataEntity> getTextBlocks() {
        return textBlocks;
    }

    public void setTextBlocks(List<DataEntity> textBlocks) {
        this.textBlocks = textBlocks;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPatternsObj() {
        return patternsObj;
    }

    public void setPatternsObj(String patternsObj) {
        this.patternsObj = patternsObj;
    }
}
