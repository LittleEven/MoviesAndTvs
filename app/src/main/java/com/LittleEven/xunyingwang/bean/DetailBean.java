package com.LittleEven.xunyingwang.bean;

import java.util.List;

public class DetailBean {
    private String mCoverUrl = "";//封面图
    private String mInfo = "";//介绍
    private String[] mTypes = null;//类型
    private List<DownLoadBean> mDownLoadBean = null;//网盘地址
    private String mOnLineUrl = "";//在线播放的地址
    private String mData = "";//基础信息显示


    public String getData() {
        return mData;
    }

    public DetailBean setData(String data) {
        mData = data;
        return this;
    }

    public String getOnLineUrl() {
        return mOnLineUrl;
    }

    public DetailBean setOnLineUrl(String onLineUrl) {
        mOnLineUrl = onLineUrl;
        return this;
    }

    public List<DownLoadBean> getDownLoadBean() {
        return mDownLoadBean;
    }

    public DetailBean setDownLoadBean(List<DownLoadBean> downLoadBean) {
        mDownLoadBean = downLoadBean;
        return this;
    }

    public String[] getTypes() {
        return mTypes;
    }

    public DetailBean setTypes(String[] types) {
        mTypes = types;
        return this;
    }

    public String getInfo() {
        return mInfo;
    }

    public DetailBean setInfo(String info) {
        mInfo = info;
        return this;
    }


    public String getCoverUrl() {
        return mCoverUrl;
    }

    public DetailBean setCoverUrl(String coverUrl) {
        mCoverUrl = coverUrl;
        return this;
    }
}
