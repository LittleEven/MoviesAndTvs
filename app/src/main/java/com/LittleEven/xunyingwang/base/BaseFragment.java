package com.LittleEven.xunyingwang.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

public class BaseFragment extends Fragment {
    protected Context mContext;
    private Toast mToast;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mContext = getActivity();
        super.onCreate(savedInstanceState);
    }

    /**
     * 显示Toast
     * @param msg
     */
    protected void showToast(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(mContext, msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
        }
        mToast.show();

    }
}
