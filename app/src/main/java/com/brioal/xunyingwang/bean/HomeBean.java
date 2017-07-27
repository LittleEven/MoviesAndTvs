package com.brioal.xunyingwang.bean;

import com.brioal.bannerview.BannerBean;

import java.util.ArrayList;
import java.util.List;

/**
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by Brioal on 2017/7/27.
 */

public class HomeBean {
    private List<BannerBean> mBanners = new ArrayList<>();//首页轮播图
    private List<RecommondBean> mRecommondBeens = new ArrayList<>();//推荐资源

    public List<BannerBean> getBanners() {
        return mBanners;
    }

    public HomeBean setBanners(List<BannerBean> banners) {
        mBanners = banners;
        return this;
    }

    public HomeBean setRecommondBeens(List<RecommondBean> recommondBeens) {
        mRecommondBeens = recommondBeens;
        return this;
    }
}
