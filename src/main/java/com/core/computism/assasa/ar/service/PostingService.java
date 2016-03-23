package com.core.computism.assasa.ar.service;

import com.core.computism.assasa.ar.transaction.IPostable;
import com.core.computism.assasa.exception.ArBusinessException;

import java.util.List;

/**
 * Created by VD on 3/8/2016.
 */
public interface PostingService {
    void doPosting(List<? extends IPostable> postingList,int transactionTypeId)throws ArBusinessException;
}
