package com.brioal.xunyingwang.tv;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brioal.xunyingwang.R;
import com.brioal.xunyingwang.base.BaseFragment;
import com.brioal.xunyingwang.bean.MovieBean;
import com.brioal.xunyingwang.tv.adapter.MyTvAdapter;
import com.brioal.xunyingwang.tv.contract.TvContract;
import com.brioal.xunyingwang.tv.presenter.TvPresenter;
import com.brioal.xunyingwang.view.ScrollRecyclerView;

import java.util.List;

import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by Brioal on 2017/7/27.
 */

public class TvFragment extends BaseFragment implements TvContract.View {
    private static TvFragment sFragment;
    private PtrFrameLayout mRefreshLayout;
    private ScrollRecyclerView mTvRecyclerView;

    public static synchronized TvFragment getInstance() {
        if (sFragment == null) {
            sFragment = new TvFragment();
        }
        return sFragment;
    }

    private View mRootView;

    private TvContract.Presenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fra_tv, container, false);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRefreshLayout=mRootView.findViewById(R.id.tv_refreshLayout);
        mTvRecyclerView=mRootView.findViewById(R.id.tv_allTvGrid);
        initPresenter();
    }

    private void initPresenter() {
        mPresenter = new TvPresenter(this);
        mPresenter.start();
    }

    @Override
    public void showRefreshing() {
        mRefreshLayout.autoRefresh(true);

    }

    @Override
    public void showList(List<MovieBean> list) {
        mRefreshLayout.refreshComplete();
        MyTvAdapter allTvAdapter = new MyTvAdapter(mContext);
        allTvAdapter.setList(list);
        mTvRecyclerView.setLayoutManager(new GridLayoutManager(mContext,3));
        mTvRecyclerView.setAdapter(allTvAdapter);
    }

    @Override
    public void showFailed(String errorMsg) {
        mRefreshLayout.refreshComplete();
        showToast(errorMsg);
    }
}
