package com.brioal.xunyingwang.bean;

/**
 * 推荐资源实体类
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by Brioal on 2017/7/27.
 */

public class RecommondBean {
    private String mId= "";//电影的ID
    private String mPicUrl = "";//图片链接
    private String mName = "";//图片名字


    public RecommondBean() {
    }

    public String getId() {
        return mId;
    }

    public RecommondBean setId(String id) {
        mId = id;
        return this;
    }

    public String getPicUrl() {
        return mPicUrl;
    }

    public RecommondBean setPicUrl(String picUrl) {
        mPicUrl = picUrl;
        return this;
    }

    public String getName() {
        return mName;
    }

    public RecommondBean setName(String name) {
        mName = name;
        return this;
    }
}
