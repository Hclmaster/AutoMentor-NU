package com.nu.automentor.myTest;

public class PostResponse {
    private int id;
    private String message;
    private String extra;

    public String getExtra() {
        return extra;
    }
    public int getId() {
        return id;
    }
    public String getMessage() {
        return message;
    }
    public void setExtra(String extra) {
        this.extra = extra;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setMessage(String message) {
        this.message = message;
    }

}