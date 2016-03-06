package com.core.computism.assasa.util;

/**
 * Created by VD on 2/28/2016.
 */
public class ServerResponse<T> {
    private T data;
    private Boolean success;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
