package com.LittleEven.xunyingwang.douban.presenter;

import android.os.Handler;

import com.LittleEven.xunyingwang.bean.RankBean;
import com.LittleEven.xunyingwang.douban.contract.DouBanContract;
import com.LittleEven.xunyingwang.douban.model.DouBanModel;

import java.util.List;

/**
 * Created by Mr.wan on 2017/8/1.
 */

public class DouBanPresenter implements DouBanContract.Presenter {
    private DouBanContract.View mView;
    private DouBanContract.Model mModel;
    private Handler mHandler = new Handler();

    public DouBanPresenter(DouBanContract.View view) {
        mView = view;
        mModel = new DouBanModel();
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
        mModel.loadDouBan(mView.getPage(),new DouBanContract.OnDouBanLoadListener(){

            @Override
            public void success(final List<RankBean> list) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mView.showRank(list);
                    }
                });
            }

            @Override
            public void failed(final String errMsg) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mView.showFailed(errMsg);
                    }
                });
            }
        });

    }

    @Override
    public void loadMore() {
        mModel.loadDouBan(mView.getPage(),new DouBanContract.OnDouBanLoadListener() {

            @Override
            public void success(final List<RankBean> list) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mView.addRank(list);
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
