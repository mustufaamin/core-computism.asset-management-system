package com.core.computism.assasa.ar.service;

import com.core.computism.assasa.ar.dto.PaymentTypeDto;
import com.core.computism.assasa.exception.ArBusinessException;

/**
 * Created by VD on 3/14/2016.
 */
public interface PaymentTypeService {
    void savePaymentType(PaymentTypeDto paymentTypeDto) throws ArBusinessException;
}
