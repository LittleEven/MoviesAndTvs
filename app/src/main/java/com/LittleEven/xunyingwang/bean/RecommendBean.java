package com.LittleEven.xunyingwang.bean;

public class RecommendBean {
    private String mId= "";//电影的ID
    private String mPicUrl = "";//图片链接
    private String mName = "";//图片名字


    public RecommendBean() {
    }

    public String getId() {
        return mId;
    }

    public RecommendBean setId(String id) {
        mId = id;
        return this;
    }

    public String getPicUrl() {
        return mPicUrl;
    }

    public RecommendBean setPicUrl(String picUrl) {
        mPicUrl = picUrl;
        return this;
    }

    public String getName() {
        return mName;
    }

    public RecommendBean setName(String name) {
        mName = name;
        return this;
    }
}
