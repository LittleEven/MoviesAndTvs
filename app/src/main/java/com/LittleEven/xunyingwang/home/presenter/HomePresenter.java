package com.LittleEven.xunyingwang.home.presenter;

import android.os.Handler;

import com.LittleEven.xunyingwang.bean.HomeBean;
import com.LittleEven.xunyingwang.home.contract.HomeContract;
import com.LittleEven.xunyingwang.home.model.HomeModel;

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
        mModel.loadHomeData(new HomeContract.OnHomeBeanLoadListener() {
            @Override
            public void success(final HomeBean homeBean) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mView.showHomeBean(homeBean);
                    }
                });
            }

            @Override
            public void failed(final String errorMsg) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mView.showRefreshFailed(errorMsg);
                    }
                });
            }
        });
    }
}
