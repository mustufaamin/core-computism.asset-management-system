package com.core.computism.assasa.ar.service.impl;

import com.core.computism.assasa.ar.builder.PaymentBuilder;
import com.core.computism.assasa.ar.dto.PaymentDto;
import com.core.computism.assasa.persistence.repository.ar.PaymentRepository;
import com.core.computism.assasa.ar.service.PaymentService;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.persistence.entity.ar.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by VD on 3/6/2016.
 */
@Service(value = "paymentService")
public class PaymentServiceImpl extends BaseService implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
    public void savePayment(PaymentDto paymentDto) throws ArBusinessException {

        Payment payment = new PaymentBuilder().setArAccountId(paymentDto.getArAccountId())
        .setReferenceArAccountId(paymentDto.getReferenceArAccountId()).setPaymentTypeId(paymentDto.getPaymentTypeId())
        .setPaymentAmount(paymentDto.getPaymentAmount()).setPaymentDate(paymentDto.getPaymentDate())
        .setPostedDate(paymentDto.getPostedDate()).setProcessedBy(paymentDto.getProcessedBy())
        .setDescription(paymentDto.getDescription()).setNote(paymentDto.getNote())
        .setStatus(paymentDto.getStatus()).setCreatedBy(paymentDto.getCreatedBy())
        .setModifiedBy(paymentDto.getModifiedBy()).setBatchId(paymentDto.getBatchId())
        .setSource(paymentDto.getSource()).setSuppressOnStatement(paymentDto.getSuppressOnStatement())
        .setStatementDescription2(paymentDto.getStatementDescription2()).setReferenceId(paymentDto.getReferenceId())
        .build();

        paymentRepository.save(payment);
    }
}
