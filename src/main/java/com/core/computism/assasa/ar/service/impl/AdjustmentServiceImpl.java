package com.core.computism.assasa.ar.service.impl;

import com.core.computism.assasa.ar.builder.AdjustmentBuilder;
import com.core.computism.assasa.ar.builder.PaymentBuilder;
import com.core.computism.assasa.ar.dto.AdjustmentDto;
import com.core.computism.assasa.ar.dto.PaymentDto;
import com.core.computism.assasa.ar.service.AdjustmentService;
import com.core.computism.assasa.ar.transaction.IMemberCharge;
import com.core.computism.assasa.ar.transaction.IPostable;
import com.core.computism.assasa.ar.transaction.Posting;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.persistence.entity.ar.Adjustment;
import com.core.computism.assasa.persistence.entity.ar.Payment;
import com.core.computism.assasa.persistence.entity.ar.PaymentType;
import com.core.computism.assasa.persistence.entity.ar.account.ArAccount;
import com.core.computism.assasa.persistence.entity.ar.billing.BillCode;
import com.core.computism.assasa.persistence.repository.ar.AdjustmentRepository;
import com.core.computism.assasa.persistence.repository.ar.ArAccountRepository;
import com.core.computism.assasa.persistence.repository.ar.BillCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by VD on 3/23/2016.
 */
@Component(value = "arAdjustmentServiceImpl")
public class AdjustmentServiceImpl implements AdjustmentService, IMemberCharge {

    @Autowired
    AdjustmentRepository adjustmentRepository;

    @Autowired
    ArAccountRepository arAccountRepository;

    @Autowired
    BillCodeRepository billCodeRepository;

    @Override
    public void saveAdjustment(AdjustmentDto adjustmentDto) throws ArBusinessException {
        Adjustment adjustment = adjustmentBuilder(adjustmentDto);
        adjustmentRepository.save(adjustment);
    }

    @Override
    public void doPost(Posting posting, List<? extends IPostable> postingList, Date transactionDate, int transactionTypeId, int userId, int companyId) throws ArBusinessException {

    }

    private Adjustment adjustmentBuilder(AdjustmentDto adjustmentDto) throws ArBusinessException{

        if(adjustmentDto.getArAccountId() == null) {
            throw new ArBusinessException("Provide Ar Account Id");
        }

        if(adjustmentDto.getBillCodeId() == null) {
            throw new ArBusinessException("Provide BillCode Id");
        }

        ArAccount arAccount = arAccountRepository.findOne(adjustmentDto.getArAccountId());
        if(arAccount == null) {
            throw new ArBusinessException("Unable to find Ar Account.");
        }

        BillCode billCode = billCodeRepository.findOne(adjustmentDto.getBillCodeId());
        if(billCode == null) {
            throw new ArBusinessException("Unable to find bill code.");
        }

        Adjustment adjustment = new AdjustmentBuilder().setArAccount(arAccount)
                .setBillCode(billCode)
                .setAmount(adjustmentDto.getAmount()).setAdjustmentDate(adjustmentDto.getAdjustmentDate())
                //.setPostedDate(adjustmentDto.getPostedDate())
                //.setProcessedBy(adjustmentDto.getProcessedBy())
                .setDescription(adjustmentDto.getDescription()).setNote(adjustmentDto.getNote())
                .setStatus(adjustmentDto.getStatus()).setCreatedBy(adjustmentDto.getCreatedBy())
                .setModifiedBy(adjustmentDto.getModifiedBy()).setBatchId(adjustmentDto.getBatchId())
                //.setSource(adjustmentDto.getSource())
                .setSuppressOnStatement(adjustmentDto.getSuppressOnStatement())
                .setStatementDescription2(adjustmentDto.getStatementDescription2())
                .build();
        return adjustment;
    }
}

