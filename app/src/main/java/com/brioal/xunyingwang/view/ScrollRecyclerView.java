package com.brioal.xunyingwang.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by Brioal on 2017/7/30.
 */

public class ScrollRecyclerView extends RecyclerView {

    public ScrollRecyclerView(Context context) {
        super(context);
    }

    public ScrollRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
