package com.core.computism.assasa.web.controller;

import com.core.computism.assasa.util.ServerResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by VD on 2/28/2016.
 */
@RequestMapping(value = "/assasa/", produces = {MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8"})
public abstract class BaseController {

    protected <T> ServerResponse<T> toResponse(T data){
        ServerResponse<T> response = new ServerResponse<>();
        response.setData(data);
        response.setSuccess(true);
        return response;
    }
}
