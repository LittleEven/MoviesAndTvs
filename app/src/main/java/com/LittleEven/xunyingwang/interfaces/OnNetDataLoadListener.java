package com.LittleEven.xunyingwang.interfaces;

public interface OnNetDataLoadListener<T> {
    void success(T bean);

    void failed(String errorMsg);
}
