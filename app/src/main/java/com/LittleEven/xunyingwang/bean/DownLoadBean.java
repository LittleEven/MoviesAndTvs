package com.LittleEven.xunyingwang.bean;

public class DownLoadBean {
    private String mTitle = "磁力";//地址类型
    private String mUrl = "";//网盘地址

    public String getTitle() {
        return mTitle;
    }

    public DownLoadBean setTitle(String title) {
        mTitle = title;
        return this;
    }

    public String getUrl() {
        return mUrl;
    }

    public DownLoadBean setUrl(String url) {
        mUrl = url;
        return this;
    }

}
