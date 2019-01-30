package com.nu.automentor.model;

import java.util.List;

public class RequestWrapper {
    private StudentEntity student;
    private List<DataEntity> textBlocks;

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
}
