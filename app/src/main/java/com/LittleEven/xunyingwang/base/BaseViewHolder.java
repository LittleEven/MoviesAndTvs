package com.LittleEven.xunyingwang.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * ViewHolder基类
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindView(T object, int position);
}
