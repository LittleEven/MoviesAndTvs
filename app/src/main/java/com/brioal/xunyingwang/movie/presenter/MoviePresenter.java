package com.brioal.xunyingwang.movie.presenter;

import android.os.Handler;

import com.brioal.xunyingwang.bean.HomeBean;
import com.brioal.xunyingwang.bean.MovieBean;
import com.brioal.xunyingwang.movie.contract.MovieContract;
import com.brioal.xunyingwang.movie.model.MovieModel;

import java.util.List;

/**
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by Brioal on 2017/7/30.
 */

public class MoviePresenter implements MovieContract.Presenter {
    private MovieContract.View mView;
    private MovieContract.Model mModel;
    private Handler mHandler = new Handler();

    public MoviePresenter(MovieContract.View view) {
        mView = view;
        mModel = new MovieModel();
    }

    @Override
    public void start() {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mView.showRefreshing();
            }
        });
        refresh();
    }

    @Override
    public void refresh() {
        mModel.loadMovies(new MovieContract.OnMoviesLoadListener() {
            @Override
            public void success(final List<MovieBean> list) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mView.showMovies(list);
                    }
                });
            }

            @Override
            public void failed(final String errorMsg) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mView.showFailed(errorMsg);
                    }
                });
            }
        });
    }
}
