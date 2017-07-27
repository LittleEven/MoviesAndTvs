package com.brioal.xunyingwang.home.presenter;

import android.os.Handler;

import com.brioal.xunyingwang.home.contract.HomeContract;
import com.brioal.xunyingwang.home.model.HomeModel;

/**
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by Brioal on 2017/7/27.
 */

public class HomePresenter implements HomeContract.Presenter {
    private HomeContract.View mView;
    private HomeContract.Model mModel;
    private Handler mHandler = new Handler();

    public HomePresenter(HomeContract.View view) {
        mView = view;
        mModel = new HomeModel();
    }

    @Override
    public void start() {
        mModel.loadHomeData();
    }

    @Override
    public void refresh() {

    }
}
