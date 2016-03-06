package com.core.computism.assasa.ar;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Created by Tafseer on 17/08/15.
 */
@JsonAutoDetect
public class Response<E> {

    private E data;

    public Response() {
    }

    public Response(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("Response{");
        sb.append("data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}
