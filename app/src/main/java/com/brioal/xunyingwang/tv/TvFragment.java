package com.brioal.xunyingwang.tv;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brioal.xunyingwang.R;
import com.brioal.xunyingwang.base.BaseFragment;
import com.brioal.xunyingwang.bean.TVBean;
import com.brioal.xunyingwang.tv.contract.TvContract;
import com.brioal.xunyingwang.tv.presenter.TvPresenter;

import java.util.List;

/**
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by Brioal on 2017/7/27.
 */

public class TvFragment extends BaseFragment implements TvContract.View {
    private static TvFragment sFragment;

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
        mRootView = inflater.inflate(R.layout.fra_layout_blank, container, false);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initPresenter();
    }

    private void initPresenter() {
        mPresenter = new TvPresenter(this);
        mPresenter.start();
    }

    @Override
    public void showRefreshing() {

    }

    @Override
    public void showList(List<TVBean> list) {

    }

    @Override
    public void showFailed(String errorMsg) {

    }
}
