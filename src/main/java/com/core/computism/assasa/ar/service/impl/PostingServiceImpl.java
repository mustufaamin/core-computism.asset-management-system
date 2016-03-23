package com.core.computism.assasa.ar.service.impl;

import com.core.computism.assasa.ar.service.PostingService;
import com.core.computism.assasa.ar.transaction.IPostable;
import com.core.computism.assasa.exception.ArBusinessException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by VD on 3/8/2016.
 */
@Component
public class PostingServiceImpl implements PostingService {

    @Override
    public void doPosting(List<? extends IPostable> postingList, int transactionTypeId) throws ArBusinessException {
        /*IMemberCharge transactionService = TransactionServiceDto.getInstance(transactionTypeId);*/
    }
}
