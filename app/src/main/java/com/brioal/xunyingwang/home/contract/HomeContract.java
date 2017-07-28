package com.brioal.xunyingwang.home.contract;

import com.brioal.xunyingwang.bean.HomeBean;

/**
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by Brioal on 2017/7/27.
 */

public interface HomeContract {
    interface Model {
        void loadHomeData(OnHomeBeanLoadListener loadListener);
    }

    interface View {
        void showRefreshing();//正在刷新

        void showHomeBean(HomeBean homeBean);//显示首页数据

        void showRefreshFailed(String errorMsg);//显示刷新失败
    }

    interface Presenter {
        void start();

        void refresh();
    }

    interface OnHomeBeanLoadListener {
        void success(HomeBean homeBean);

        void failed(String errorMsg);
    }
}
