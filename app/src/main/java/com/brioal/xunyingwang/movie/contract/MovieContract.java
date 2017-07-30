package com.brioal.xunyingwang.movie.contract;

import com.brioal.xunyingwang.bean.MovieBean;

import java.util.List;

/**
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by Brioal on 2017/7/30.
 */

public interface MovieContract {
    interface Model {
        void loadMovies(OnMoviesLoadListener loadListener);
    }

    interface View {
        void showRefreshing();//显示正在刷新

        void showMovies(List<MovieBean> list);//显示电影列表

        void showFailed(String errorMsg);//显示刷新失败

    }

    interface Presenter {
        void start();

        void refresh();
    }

    interface OnMoviesLoadListener {
        void success(List<MovieBean> list);

        void failed(String errorMsg);
    }
}
