package com.core.computism.assasa.ar.service.impl;

import com.core.computism.assasa.ar.service.CustomerChargeService;
import com.core.computism.assasa.ar.transaction.IMemberCharge;
import com.core.computism.assasa.ar.transaction.IPostable;
import com.core.computism.assasa.ar.transaction.Posting;
import com.core.computism.assasa.exception.ArBusinessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by VD on 3/23/2016.
 */
@Component(value = "customerChargeServiceImpl")
public class CustomerChargeServiceImpl implements CustomerChargeService, IMemberCharge {
    @Override
    public void doPost(Posting posting, List<? extends IPostable> postingList, String transactionDate, int transactionTypeId, int userId, int companyId) throws ArBusinessException {

    }
}
