package com.brioal.xunyingwang.movie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brioal.xunyingwang.R;
import com.brioal.xunyingwang.base.BaseFragment;
import com.brioal.xunyingwang.bean.MovieBean;
import com.brioal.xunyingwang.movie.contract.MovieContract;
import com.brioal.xunyingwang.movie.presenter.MoviePresenter;

import java.util.List;

/**
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by Brioal on 2017/7/27.
 */

public class MovieFragment extends BaseFragment implements MovieContract.View {
    private static MovieFragment sFragment;

    public static synchronized MovieFragment getInstance() {
        if (sFragment == null) {
            sFragment = new MovieFragment();
        }
        return sFragment;
    }

    private View mRootView;
    private MovieContract.Presenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fra_layout_blank, container, false);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initPresenter();
    }

    private void initPresenter() {
        mPresenter = new MoviePresenter(this);
        mPresenter.start();
    }

    @Override
    public void showRefreshing() {

    }

    @Override
    public void showMovies(List<MovieBean> list) {

    }

    @Override
    public void showFailed(String errorMsg) {

    }
}
