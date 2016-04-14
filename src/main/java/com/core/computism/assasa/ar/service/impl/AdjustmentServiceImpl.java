package com.core.computism.assasa.ar.service.impl;

import com.core.computism.assasa.ar.builder.AdjustmentBuilder;
import com.core.computism.assasa.ar.dto.AdjustmentDto;
import com.core.computism.assasa.ar.dto.service.TransactionServiceDto;
import com.core.computism.assasa.ar.service.AdjustmentService;
import com.core.computism.assasa.ar.transaction.IMemberCharge;
import com.core.computism.assasa.ar.transaction.IPostable;
import com.core.computism.assasa.ar.transaction.Posting;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.persistence.entity.ar.Adjustment;
import com.core.computism.assasa.persistence.entity.ar.account.ArAccount;
import com.core.computism.assasa.persistence.entity.ar.billing.BillCode;
import com.core.computism.assasa.persistence.repository.ar.AdjustmentRepository;
import com.core.computism.assasa.persistence.repository.ar.ArAccountRepository;
import com.core.computism.assasa.persistence.repository.ar.BillCodeRepository;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Autowired
    TransactionServiceDto transactionServiceDto;

    @Autowired
    Posting posting;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
    public void saveAdjustment(AdjustmentDto adjustmentDto) throws ArBusinessException {
        Adjustment adjustment = adjustmentBuilder(adjustmentDto);
        adjustmentRepository.save(adjustment);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
    public void saveNPostAdjustment(AdjustmentDto adjustmentDto) throws ArBusinessException {
        Adjustment adjustment = adjustmentBuilder(adjustmentDto);
        adjustmentRepository.save(adjustment);

        if (adjustment.getStatus().equals(TransactionServiceDto.UN_POSTED_CHARGE_POST_STATUS)) {
            List<Adjustment> adjustments = new ArrayList<>();
            adjustments.add(adjustment);

            if (CollectionUtils.isNotEmpty(adjustments)) {
                post(adjustments);
            }
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
    private void post(List<? extends IPostable> postingList) throws ArBusinessException {
        /*Posting posting = new Posting(TransactionServiceDto.ADJUSTMENT_TR_ID, 1, 1);
        posting.setPostingList(postingList);*/
        posting.doPosting(postingList, TransactionServiceDto.ADJUSTMENT_TR_ID, 1, 1);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
    public void doPost(Posting posting, List<? extends IPostable> postingList, Date transactionDate, int transactionTypeId, int userId, int companyId) throws ArBusinessException {
        List<Adjustment> adjustments = (ArrayList<Adjustment>) (postingList);
        transactionServiceDto.basicPosting(posting, postingList, transactionDate, transactionTypeId, userId, companyId);
        updateAdjustments(adjustments);
    }

    private void updateAdjustments(List<Adjustment> adjustments) {
        adjustmentRepository.save(adjustments);
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

        Adjustment adjustment = new AdjustmentBuilder()
                .setArAccount(arAccount)
                .setBillCode(billCode)
                .setAdjustmentDate(adjustmentDto.getAdjustmentDate())
                .setAmount(adjustmentDto.getAmount())
                .setAdjustmentType(adjustmentDto.getAdjustmentType())
                .setStatus(adjustmentDto.getStatus())
                .setBatchId(adjustmentDto.getBatchId())
                .setDescription(adjustmentDto.getDescription())
                .setStatementDescription2(adjustmentDto.getStatementDescription2())
                .setNote(adjustmentDto.getNote())
                .setSuppressOnStatement(adjustmentDto.getSuppressOnStatement())
                .setExcludeValueAdded(adjustmentDto.getExcludeValueAdded())
                .setCreatedBy(adjustmentDto.getCreatedBy())
                .setModifiedBy(adjustmentDto.getModifiedBy())
                .build();
        return adjustment;
    }
}

