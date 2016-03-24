package com.core.computism.assasa.ar.dto;

import com.core.computism.assasa.ar.transaction.IMemberCharge;
import com.core.computism.assasa.ar.transaction.IPostable;
import com.core.computism.assasa.ar.transaction.Posting;
import com.core.computism.assasa.exception.ArBusinessException;

import java.util.List;

/**
 * Created by VD on 3/13/2016.
 */
public class POSServiceDto implements IMemberCharge{
    @Override
    public void doPost(Posting posting, List<? extends IPostable> postingList, String transactionDate, int transactionTypeId, int userId, int companyId) throws ArBusinessException {

    }
}
