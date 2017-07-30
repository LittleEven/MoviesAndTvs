package com.brioal.xunyingwang.movie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brioal.xunyingwang.R;
import com.brioal.xunyingwang.base.BaseFragment;
import com.brioal.xunyingwang.bean.MovieBean;
import com.brioal.xunyingwang.home.adapter.MovieAdapter;
import com.brioal.xunyingwang.movie.adapter.MyMovieAdapter;
import com.brioal.xunyingwang.movie.contract.MovieContract;
import com.brioal.xunyingwang.movie.presenter.MoviePresenter;
import com.brioal.xunyingwang.view.ScrollRecyclerView;

import java.util.List;

import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by Brioal on 2017/7/27.
 */

public class MovieFragment extends BaseFragment implements MovieContract.View {
    private static MovieFragment sFragment;
    private PtrFrameLayout mRefreshLayout;
    private ScrollRecyclerView mMovieRecyclerView;

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
        mRootView = inflater.inflate(R.layout.fra_movie, container, false);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRefreshLayout=mRootView.findViewById(R.id.movie_refreshLayout);
        mMovieRecyclerView=mRootView.findViewById(R.id.movie_allMovieGrid);
        initPresenter();
    }

    private void initPresenter() {
        mPresenter = new MoviePresenter(this);
        mPresenter.start();
    }

    @Override
    public void showRefreshing() {
        mRefreshLayout.autoRefresh(true);
    }

    @Override
    public void showMovies(List<MovieBean> list) {
        mRefreshLayout.refreshComplete();
        MyMovieAdapter allMovieAdapter = new MyMovieAdapter(mContext);
        allMovieAdapter.setList(list);
        mMovieRecyclerView.setLayoutManager(new GridLayoutManager(mContext,3));
        mMovieRecyclerView.setAdapter(allMovieAdapter);
    }

    @Override
    public void showFailed(String errorMsg) {
        mRefreshLayout.refreshComplete();
        showToast(errorMsg);
    }
}
