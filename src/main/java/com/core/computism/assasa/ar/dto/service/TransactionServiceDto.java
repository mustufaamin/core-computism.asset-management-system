package com.core.computism.assasa.ar.dto.service;

import com.core.computism.assasa.ar.service.ArAccountService;
import com.core.computism.assasa.ar.service.PaymentService;
import com.core.computism.assasa.ar.service.TransactionService;
import com.core.computism.assasa.ar.transaction.IMemberCharge;
import com.core.computism.assasa.ar.transaction.IPostable;
import com.core.computism.assasa.ar.transaction.Posting;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.persistence.entity.ar.Transaction;
import com.core.computism.assasa.persistence.repository.ar.ArAccountRepository;
import com.core.computism.assasa.persistence.repository.ar.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by VD on 3/13/2016.
 */
@Service(value = "transactionServiceDto")
public class TransactionServiceDto implements IMemberCharge {

    public final static int PERIODIC_TR_ID = 1;
    public final static int ADJUSTMENT_TR_ID = 2;
    public final static int PAYMENT_TR_ID = 3;
    public final static int POS_TR_ID = 4;

    public final static int POSTED_CHARGE_POST_STATUS = 1;
    public final static int UN_POSTED_CHARGE_POST_STATUS = 2;
    public final static int REVERSED_CHARGE_POST_STATUS = 3;

    public TransactionServiceDto() {}

    @Autowired
    TransactionService transactionService;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    ArAccountRepository arAccountRepository;

    @Autowired
    Map<String,IMemberCharge> iMemberChargeMap;

    public IMemberCharge getInstance(int transactionTypeId) throws ArBusinessException {
        IMemberCharge memberCharge = null;
        switch (transactionTypeId) {
            case PAYMENT_TR_ID: {
                memberCharge = iMemberChargeMap.get("arPaymentServiceImpl");
                break;
            }
            case ADJUSTMENT_TR_ID: {
                memberCharge = iMemberChargeMap.get("arAdjustmentServiceImpl");
                break;
            }
            case PERIODIC_TR_ID: {
                memberCharge = iMemberChargeMap.get("customerChargeServiceImpl");
                break;
            }
            case POS_TR_ID: {
                memberCharge = iMemberChargeMap.get("paymentServiceImpl");
            }

        }
        return memberCharge;
    }

    @Override
    public void doPost(Posting posting, List<? extends IPostable> postingList, String transactionDate, int transactionTypeId, int userId, int companyId) throws ArBusinessException {
       /* basicPosting(posting, (postingList), transactionDate, transactionTypeId, userId, companyId);
        memberCharge.doPost(posting, postingList, transactionDate, transactionTypeId, userId, companyId);*/
    }

    public void basicPosting(Posting posting, List<? extends IPostable> postingList, String transactionDate, int transactionTypeId, int userId, int companyId) throws ArBusinessException {
        /*List<? extends IJournalizeable> journalizeables = (List<? extends IJournalizeable>) (postingList);

        posting.journalTransactions(journalizeables);*/

        //TransactionList tList = new TransactionList(companyId);
        List<Transaction> transactions = transactionService.populateTransaction(postingList, transactionDate, transactionTypeId, userId);
        transactionRepository.save(transactions);

        updateBalance(transactions);
        updatePostableStatus(postingList);
    }

    private void updatePostableStatus(List<? extends IPostable> postingObjects) //throws Exception
    {
        for(IPostable postable: postingObjects)
        {
            postable.setStatus(POSTED_CHARGE_POST_STATUS);
        }
    }

    private void updateBalance(List<Transaction> transactions) {
        //TODO named query to update arAccount amount.
        for(Transaction transaction : transactions) {
            transaction.getTotalAmount();
        }
    }
}
