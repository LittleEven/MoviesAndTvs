package com.LittleEven.xunyingwang.detail.contract;

import com.LittleEven.xunyingwang.interfaces.OnNetDataLoadListener;
import com.LittleEven.xunyingwang.bean.DetailBean;

public interface DetailContract {
    interface Model {
        void loadDetail(String type, String id, OnNetDataLoadListener<DetailBean> loadListener);
    }

    interface View {
        void showRefreshing();

        void showData(DetailBean bean);

        void showFailed(String errorMsg);

        String getId();

        String getType();

    }

    interface Presenter {
        void start();

        void refresh();
    }
}
