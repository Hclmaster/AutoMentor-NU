package com.nu.automentor.model;

import java.util.List;

public class ResponseWrapper {
    private StudentEntity student;
    private List<DataEntity> textBlocks;
    private List<String> response;

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
}
