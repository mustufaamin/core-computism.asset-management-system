package com.core.computism.assasa.ar.service;

import com.core.computism.assasa.ar.dto.PaymentTypeDto;
import com.core.computism.assasa.exception.ArBusinessException;

import java.util.List;

/**
 * Created by VD on 3/14/2016.
 */
public interface PaymentTypeService {
    void savePaymentType(PaymentTypeDto paymentTypeDto) throws ArBusinessException;

    void updatePaymentType(PaymentTypeDto paymentTypeDto) throws ArBusinessException;

    List<PaymentTypeDto> getPaymentTypes() throws ArBusinessException;

    List<PaymentTypeDto> getPaymentTypesByStatus(Integer status) throws ArBusinessException;
}
