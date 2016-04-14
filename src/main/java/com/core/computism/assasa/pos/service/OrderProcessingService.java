package com.core.computism.assasa.pos.service;

import com.core.computism.assasa.pos.domain.PosOrderDto;

/**
 * Created by VD on 4/13/2016.
 */
public interface OrderProcessingService {
    boolean processOrder(PosOrderDto posOrderDto);
}
