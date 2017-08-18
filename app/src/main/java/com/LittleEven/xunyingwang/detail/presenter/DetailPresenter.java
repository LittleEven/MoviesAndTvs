package com.LittleEven.xunyingwang.detail.presenter;

import android.os.Handler;

import com.LittleEven.xunyingwang.bean.DetailBean;
import com.LittleEven.xunyingwang.detail.contract.DetailContract;
import com.LittleEven.xunyingwang.detail.model.DetailModel;
import com.LittleEven.xunyingwang.interfaces.OnNetDataLoadListener;

public class DetailPresenter implements DetailContract.Presenter {
    private DetailContract.View mView;
    private DetailContract.Model mModel;
    private Handler mHandler = new Handler();

    public DetailPresenter(DetailContract.View view) {
        mView = view;
        mModel = new DetailModel();
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
        mModel.loadDetail(mView.getType(), mView.getId(), new OnNetDataLoadListener<DetailBean>() {
            @Override
            public void success(final DetailBean bean) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mView.showData(bean);
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
