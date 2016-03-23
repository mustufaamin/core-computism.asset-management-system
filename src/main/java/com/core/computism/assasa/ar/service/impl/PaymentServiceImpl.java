package com.core.computism.assasa.ar.service.impl;

import com.core.computism.assasa.ar.builder.PaymentBuilder;
import com.core.computism.assasa.ar.dto.PaymentDto;
import com.core.computism.assasa.ar.dto.service.TransactionServiceDto;
import com.core.computism.assasa.ar.service.PaymentService;
import com.core.computism.assasa.ar.transaction.IMemberCharge;
import com.core.computism.assasa.ar.transaction.IPostable;
import com.core.computism.assasa.ar.transaction.Posting;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.persistence.entity.ar.Payment;
import com.core.computism.assasa.persistence.repository.ar.PaymentRepository;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VD on 3/6/2016.
 */
@Service(value = "paymentServiceImpl")
public class PaymentServiceImpl extends BaseService implements PaymentService, IMemberCharge {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    TransactionServiceDto transactionServiceDto;

    @Autowired
    Posting posting;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
    public void savePayment(PaymentDto paymentDto) throws ArBusinessException {
        Payment payment = paymentBuilder(paymentDto);
        paymentRepository.save(payment);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
    public void saveNPostPayment(PaymentDto paymentDto) throws ArBusinessException {
        Payment payment = paymentBuilder(paymentDto);
        paymentRepository.save(payment);

        if (payment.getStatus().equals(TransactionServiceDto.UN_POSTED_CHARGE_POST_STATUS)) {
            List<Payment> payments = new ArrayList<>();
            payments.add(payment);

            if (CollectionUtils.isNotEmpty(payments)) {
                post(payments);
            }
        }
    }

    private void post(List<? extends IPostable> postingList) throws ArBusinessException {
        /*Posting posting = new Posting(TransactionServiceDto.PAYMENT_TR_ID, 1, 1);
        posting.setPostingList(postingList);*/
        posting.doPosting(postingList);
    }

    private Payment paymentBuilder(PaymentDto paymentDto) {
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
        return payment;
    }

    @Override
    public void doPost(Posting posting, List<? extends IPostable> postingList, String transactionDate, int transactionTypeId, int userId, int companyId) throws ArBusinessException {
        List<Payment> payments = (ArrayList<Payment>) (postingList);
        transactionServiceDto.basicPosting(posting, postingList, transactionDate, transactionTypeId, userId, companyId);
        updatePayments(payments);
    }

    private void updatePayments(List<Payment> payments) {
        paymentRepository.save(payments);
    }
}
