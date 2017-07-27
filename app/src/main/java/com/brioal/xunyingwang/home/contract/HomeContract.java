package com.brioal.xunyingwang.home.contract;

/**
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by Brioal on 2017/7/27.
 */

public interface HomeContract {
    interface Model {
        void loadHomeData();
    }

    interface View {

    }

    interface Presenter {
        void start();

        void refresh();
    }
}
