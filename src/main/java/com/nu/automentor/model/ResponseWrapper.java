package com.nu.automentor.model;

import java.util.List;

public class ResponseWrapper {
    private StudentEntity stu;
    private List<DataEntity> dataLst;
    private List<String> response;

    public StudentEntity getStu() {
        return stu;
    }

    public void setStu(StudentEntity stu) {
        this.stu = stu;
    }

    public List<String> getResponse() {
        return response;
    }

    public void setResponse(List<String> response) {
        this.response = response;
    }

    public List<DataEntity> getDataLst() {
        return dataLst;
    }

    public void setDataLst(List<DataEntity> dataLst) {
        this.dataLst = dataLst;
    }
}
