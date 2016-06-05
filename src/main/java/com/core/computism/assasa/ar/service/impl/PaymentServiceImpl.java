package com.core.computism.assasa.ar.service.impl;

import com.core.computism.assasa.ar.builder.PaymentBuilder;
import com.core.computism.assasa.ar.dto.PaymentDto;
import com.core.computism.assasa.ar.dto.service.TransactionServiceDto;
import com.core.computism.assasa.ar.service.PaymentService;
import com.core.computism.assasa.ar.transaction.IMemberCharge;
import com.core.computism.assasa.ar.transaction.IPostable;
import com.core.computism.assasa.ar.transaction.Posting;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.persistence.entity.ar.Payment;
import com.core.computism.assasa.persistence.entity.ar.PaymentType;
import com.core.computism.assasa.persistence.entity.ar.account.ArAccount;
import com.core.computism.assasa.persistence.repository.ar.ArAccountRepository;
import com.core.computism.assasa.persistence.repository.ar.PaymentRepository;
import com.core.computism.assasa.persistence.repository.ar.PaymentTypeRepository;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by VD on 3/6/2016.
 */
@Component(value = "arPaymentServiceImpl")
public class PaymentServiceImpl extends BaseService implements PaymentService, IMemberCharge {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    TransactionServiceDto transactionServiceDto;

    @Autowired
    Posting posting;

    @Autowired
    ArAccountRepository arAccountRepository;

    @Autowired
    PaymentTypeRepository paymentTypeRepository;

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

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
    private void post(List<? extends IPostable> postingList) throws ArBusinessException {
        /*Posting posting = new Posting(TransactionServiceDto.PAYMENT_TR_ID, 1, 1);
        posting.setPostingList(postingList);*/
        posting.doPosting(postingList, TransactionServiceDto.PAYMENT_TR_ID, 1, 1);
    }

    private Payment paymentBuilder(PaymentDto paymentDto) throws ArBusinessException{

        if(paymentDto.getArAccountId() == null) {
            throw new ArBusinessException("Provide Ar Account Id");
        }

        if(paymentDto.getPaymentTypeId() == null) {
            throw new ArBusinessException("Provide Payment Type Id");
        }

        ArAccount arAccount = arAccountRepository.findOne(paymentDto.getArAccountId());
        if(arAccount == null) {
            throw new ArBusinessException("Unable to find Ar Account.");
        }

        PaymentType paymentType = paymentTypeRepository.findOne(paymentDto.getPaymentTypeId());
        if(paymentType == null) {
            throw new ArBusinessException("Unable to find Payment Type.");
        }

        Payment payment = new PaymentBuilder().setArAccount(arAccount)
                .setReferenceArAccountId(paymentDto.getReferenceArAccountId()).setPaymentType(paymentType)
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
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
    public void doPost(Posting posting, List<? extends IPostable> postingList, Date transactionDate, int transactionTypeId, int userId, int companyId) throws ArBusinessException {
        List<Payment> payments = (ArrayList<Payment>) (postingList);
        transactionServiceDto.basicPosting(posting, postingList, transactionDate, transactionTypeId, userId, companyId);
        updatePayments(payments);
    }

    private void updatePayments(List<Payment> payments) {
        paymentRepository.save(payments);
    }

    @Override
    public List<PaymentDto> getPaymentsByCustomerId(Long customerId) throws ArBusinessException {
        try {
            List<Payment> payments = paymentRepository.getPaymentByCustomerId(customerId);
            return new PaymentBuilder().buildPaymentDtoList(payments);

        } catch (PersistenceException | BuilderException e) {
            throw new ArBusinessException("Error occurred In payment service Update", e);
        }
    }
}
