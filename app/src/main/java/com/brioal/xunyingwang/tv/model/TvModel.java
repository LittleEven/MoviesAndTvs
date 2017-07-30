package com.brioal.xunyingwang.tv.model;

import com.brioal.xunyingwang.tv.contract.TvContract;

/**
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by Brioal on 2017/7/30.
 */

public class TvModel implements TvContract.Model {
    private String URL_TVS = "http://www.xunyingwang.com/tv";


    @Override
    public void loadTvs(TvContract.OnTvLoadListener loadListener) {
        //解析电视剧列表
        //参照首页Model
    }
}
