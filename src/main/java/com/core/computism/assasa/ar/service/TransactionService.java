package com.core.computism.assasa.ar.service;

import com.core.computism.assasa.ar.transaction.IPostable;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.persistence.entity.ar.Transaction;

import java.util.List;

/**
 * Created by VD on 3/19/2016.
 */
public interface TransactionService {

    public List<Transaction> populateTransaction(List<? extends IPostable> postingObjectsSubList, String transactionDate,
                                                 int transactionTypeId, int createdBy) throws ArBusinessException;
}
