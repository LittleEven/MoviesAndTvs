package com.LittleEven.xunyingwang.movie.presenter;

import android.os.Handler;

import com.LittleEven.xunyingwang.bean.MovieBean;
import com.LittleEven.xunyingwang.movie.contract.MovieContract;
import com.LittleEven.xunyingwang.movie.model.MovieModel;

import java.util.List;

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
        mModel.loadMovies(mView.getYear(), mView.getRank(), mView.getArea(), mView.getType(), mView.getPage(), new MovieContract.OnMoviesLoadListener() {
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

    @Override
    public void loadMore() {
        mModel.loadMovies(mView.getYear(), mView.getRank(), mView.getArea(), mView.getType(), mView.getPage(), new MovieContract.OnMoviesLoadListener() {
            @Override
            public void success(final List<MovieBean> list) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mView.addMovies(list);
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
