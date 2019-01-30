package com.nu.automentor.model;

import java.util.List;

public class RequestWrapper {
    private StudentEntity stu;
    private List<DataEntity> dataLst;

    public StudentEntity getStu() {
        return stu;
    }

    public void setStu(StudentEntity stu) {
        this.stu = stu;
    }

    public List<DataEntity> getDataLst() {
        return dataLst;
    }

    public void setDataLst(List<DataEntity> dataLst) {
        this.dataLst = dataLst;
    }
}
