package com.core.computism.assasa.ar.service;

import com.core.computism.assasa.exception.ArBusinessException;

/**
 * Created by VD on 5/28/2016.
 */
public interface ArOrderService {
    Long generateOrder(Long quotationId) throws ArBusinessException;
}
