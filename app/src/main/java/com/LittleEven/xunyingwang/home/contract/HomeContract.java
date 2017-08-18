package com.LittleEven.xunyingwang.home.contract;

import com.LittleEven.xunyingwang.bean.HomeBean;

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
