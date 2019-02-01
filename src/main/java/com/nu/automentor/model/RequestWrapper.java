package com.nu.automentor.model;

import java.util.List;

public class RequestWrapper {
    private StudentEntity student;
    private List<DataEntity> textBlocks;
    private String message;

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
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
}
