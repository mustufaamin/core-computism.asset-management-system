package com.core.computism.assasa.ar.service;

import com.core.computism.assasa.ar.dto.PaymentDto;
import com.core.computism.assasa.exception.ArBusinessException;

import java.util.List;

/**
 * Created by VD on 3/6/2016.
 */
public interface PaymentService {
    public void savePayment(PaymentDto paymentDto) throws ArBusinessException;

    public void saveNPostPayment(PaymentDto paymentDto) throws ArBusinessException;

    public List<PaymentDto> getPaymentsByCustomerId(Long customerId) throws ArBusinessException;
}
