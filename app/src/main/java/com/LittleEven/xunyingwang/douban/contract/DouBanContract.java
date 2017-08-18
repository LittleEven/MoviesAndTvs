package com.LittleEven.xunyingwang.douban.contract;

import com.LittleEven.xunyingwang.bean.RankBean;

import java.util.List;

/**
 * Created by Mr.wan on 2017/8/1.
 */

public interface DouBanContract {
    interface Model {

        void loadDouBan(int page, OnDouBanLoadListener onDouBanLoadListener);

    }

    interface View {

        void showRefreshing();//显示正在刷新

        void showRank(List<RankBean> list);//显示排行榜列表

        void addRank(List<RankBean> list);//添加排行榜列表

        void showFailed(String errorMsg);//显示刷新失败

        int getPage();

    }

    interface Presenter {

        void start();

        void refresh();

        void loadMore();

    }

    interface OnDouBanLoadListener {
        void success(List<RankBean> list);

        void failed(String errMsg);
    }
}
