package com.core.computism.assasa.ar.transaction;

import com.core.computism.assasa.exception.ArBusinessException;

import java.util.Date;
import java.util.List;

public interface IMemberCharge
{
	public void doPost(Posting posting, List<? extends IPostable> postingList, Date transactionDate, int transactionTypeId, int userId, int companyId)throws ArBusinessException;
}