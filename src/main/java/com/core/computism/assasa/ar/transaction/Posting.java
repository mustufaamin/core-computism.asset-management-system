package com.core.computism.assasa.ar.transaction;

import com.core.computism.assasa.ar.dto.service.IJournalizeable;
import com.core.computism.assasa.ar.dto.service.TransactionServiceDto;
import com.core.computism.assasa.exception.ArBusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VD on 3/8/2016.
 */
@Component
public class Posting {

    private int transactionTypeId = 3;
    private int companyId;
    private int createdBy;
    private List<? extends IPostable> postingList;

    public Posting() {
    }

    @Autowired
    TransactionServiceDto transactionServiceDto;

    public Posting(int companyId) {
        postingList = new ArrayList<IPostable>();
        transactionTypeId = 0;
        this.companyId = companyId;
    }

    public Posting(int transactionTypeId, int createdBy, int companyId) {
        this(companyId);
        this.transactionTypeId = transactionTypeId;
        this.createdBy = createdBy;
    }

    public int getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(int transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public List<? extends IPostable> getPostingList() {
        return postingList;
    }

    public void setPostingList(List<? extends IPostable> postingList) {
        this.postingList = postingList;
    }

    public void doPosting(List<? extends IPostable> postingList) throws ArBusinessException {
        doPosting(postingList, this.transactionTypeId);
    }

    public void doPosting(List<? extends IPostable> postingObjectsSubList, int transactionTypeId) throws ArBusinessException {
        IMemberCharge transactionService = transactionServiceDto.getInstance(transactionTypeId);
        switch (transactionTypeId) {

            case TransactionServiceDto.PERIODIC_TR_ID:
            case (TransactionServiceDto.ADJUSTMENT_TR_ID):
            case (TransactionServiceDto.PAYMENT_TR_ID): {
                transactionService.doPost(this, postingObjectsSubList, "", transactionTypeId, this.getCreatedBy(), companyId);
                break;
            }
        }
    }

    public void journalTransactions(List<? extends IJournalizeable> journalizeables) throws ArBusinessException {
        for(IJournalizeable journalizeable : journalizeables) {
            journalizeable.getJournalizeableControlItem();
        }
    }
}
