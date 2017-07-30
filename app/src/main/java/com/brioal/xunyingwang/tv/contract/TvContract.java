package com.brioal.xunyingwang.tv.contract;

import com.brioal.xunyingwang.bean.TVBean;

import java.util.List;

/**
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by Brioal on 2017/7/30.
 */

public interface TvContract {
    interface Model {
        void loadTvs(OnTvLoadListener loadListener);
    }

    interface View {
        void showRefreshing();

        void showList(List<TVBean> list);

        void showFailed(String errorMsg);
    }

    interface Presenter {
        void start();

        void refresh();
    }

    interface OnTvLoadListener{
        void success(List<TVBean> list);

        void failed(String errorMsg);
    }
}
