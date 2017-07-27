package com.brioal.xunyingwang.bean;

/**
 * 电视剧实体类
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by Brioal on 2017/7/27.
 */

public class TVBean {
    private String mID = "";//ID
    private String mName = "";//名称
    private String mActors = "";//演员
    private String mCoverUrl = "";//封面地址
    private String mRank = "";//评分

    public String getRank() {
        return mRank;
    }

    public TVBean setRank(String rank) {
        mRank = rank;
        return this;
    }

    public String getID() {
        return mID;
    }

    public TVBean setID(String ID) {
        mID = ID;
        return this;
    }

    public String getName() {
        return mName;
    }

    public TVBean setName(String name) {
        mName = name;
        return this;
    }

    public String getActors() {
        return mActors;
    }

    public TVBean setActors(String actors) {
        mActors = actors;
        return this;
    }

    public String getCoverUrl() {
        return mCoverUrl;
    }

    public TVBean setCoverUrl(String coverUrl) {
        mCoverUrl = coverUrl;
        return this;
    }
}
