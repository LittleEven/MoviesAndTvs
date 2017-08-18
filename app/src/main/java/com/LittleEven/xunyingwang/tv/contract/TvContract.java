package com.LittleEven.xunyingwang.tv.contract;

import com.LittleEven.xunyingwang.bean.MovieBean;

import java.util.List;

public interface TvContract {
    interface Model {
        void loadTvs(String year, String rank, String area, String type, int pager, OnTvLoadListener loadListener);
    }

    interface View {
        void showRefreshing();


        void showList(List<MovieBean> list);


        void showFailed(String errorMsg);

        void addTvs(List<MovieBean> list);

        String getYear();

        String getRank();

        String getArea();

        String getType();

        int getPage();
    }

    interface Presenter {
        void start();

        void refresh();

        void loadMore();
    }

    interface OnTvLoadListener{
        void success(List<MovieBean> list);

        void failed(String errorMsg);
    }
}
