package com.brioal.xunyingwang.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brioal.xunyingwang.R;
import com.brioal.xunyingwang.base.BaseFragment;
import com.brioal.xunyingwang.home.contract.HomeContract;
import com.brioal.xunyingwang.home.presenter.HomePresenter;

/**
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by Brioal on 2017/7/27.
 */

public class HomeFragment extends BaseFragment implements HomeContract.View {
    private static HomeFragment sFragment;
    private HomeContract.Presenter mPresenter;

    public static synchronized HomeFragment getInstance() {
        if (sFragment == null) {
            sFragment = new HomeFragment();
        }
        return sFragment;
    }

    private View mRootView;

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
        mPresenter = new HomePresenter(this);
        mPresenter.start();
    }
}
