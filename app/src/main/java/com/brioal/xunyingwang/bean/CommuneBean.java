package com.brioal.xunyingwang.bean;

/**
 * Created by Mr.wan on 2017/7/31.
 */

public class CommuneBean {
    private String tittle = "";
    private String author = "";
    private String time = "";
    private String type = "";
    private String topUrl = "";

    public String getTittle() {
        return tittle;
    }

    public CommuneBean setTittle(String tittle) {
        this.tittle = tittle;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public CommuneBean setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getTime() {
        return time;
    }

    public CommuneBean setTime(String time) {
        this.time = time;
        return this;
    }

    public String getType() {
        return type;
    }

    public CommuneBean setType(String type) {
        this.type = type;
        return this;
    }

    public String getTopUrl() {
        return topUrl;
    }

    public CommuneBean setTopUrl(String topUrl) {
        this.topUrl = topUrl;
        return this;
    }


}
