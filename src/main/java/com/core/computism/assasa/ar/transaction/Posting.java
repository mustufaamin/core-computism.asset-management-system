package com.core.computism.assasa.ar.transaction;

import com.core.computism.assasa.ar.IJournalizeableItem;
import com.core.computism.assasa.ar.dto.service.IJournalizeable;
import com.core.computism.assasa.ar.dto.service.JournalEntryItem;
import com.core.computism.assasa.ar.dto.service.JournalizeableItem;
import com.core.computism.assasa.ar.dto.service.JournalizeableItemDetail;
import com.core.computism.assasa.ar.dto.service.TransactionServiceDto;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.persistence.entity.gl.admin.GlAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VD on 3/8/2016.
 */
@Component
public class Posting {

    private List<? extends IPostable> postingList;

    @Autowired
    TransactionServiceDto transactionServiceDto;




    public List<? extends IPostable> getPostingList() {
        return postingList;
    }

    public void setPostingList(List<? extends IPostable> postingList) {
        this.postingList = postingList;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
    public void doPosting(List<? extends IPostable> postingList, int transactionTypeId, int createdBy, int companyId) throws ArBusinessException {
        IMemberCharge transactionService = transactionServiceDto.getInstance(transactionTypeId);
        switch (transactionTypeId) {

            case TransactionServiceDto.PERIODIC_TR_ID:
            case (TransactionServiceDto.ADJUSTMENT_TR_ID):
            case (TransactionServiceDto.PAYMENT_TR_ID): {
                transactionService.doPost(this, postingList, "", transactionTypeId, createdBy, companyId);
                break;
            }
        }
    }

    public void journalTransactions(List<? extends IJournalizeable> journalizeables) throws ArBusinessException {
        for (IJournalizeable journalizeable : journalizeables) {
            journalizeable.getJournalizeableControlItem();

            String journalEntryItemComments = journalizeable.getSubLedgerAccountName();

            //Bill-code or Payment type
            IJournalizeableItem journalizeableItem = journalizeable.getJournalizeableMainItem();
            String mainItemDescription = journalizeableItem.getJournalizeableItemName();

            IJournalizeableItem ijournalizeableControlItem = journalizeable.getJournalizeableControlItem();
            JournalizeableItemDetail journalizeableControlItemDetail = new JournalizeableItemDetail(new BigDecimal(0.00), new BigDecimal(0.00));
            JournalizeableItem journalizeableControlItem = new JournalizeableItem(ijournalizeableControlItem, journalizeableControlItemDetail);

            List<JournalEntryItem> journalizeableItemsControl = getJournalizeableItems(journalizeableControlItem, journalizeable.getAccountDetail(),
                    (mainItemDescription + " / " + journalEntryItemComments));
            JournalEntryItem journalizeableItemControl = journalizeableItemsControl.get(0);

            GlAccount glAccount = journalizeableItemControl.getAccountDetail();
            int primaryCompanyForJournalEntry = glAccount.getCompanyId(); //AR Account Company
            ArrayList<JournalEntryItem> totalJournalizeableItems = new ArrayList<JournalEntryItem>();

            BigDecimal mainItemAmount = journalizeable.getJournalizeableMainItemAmount();
            BigDecimal mainItemQuantity = journalizeable.getJournalizeableMainItemQuantity();
            JournalizeableItemDetail journalizeableItemDetail = new JournalizeableItemDetail(mainItemAmount, mainItemQuantity);
            JournalizeableItem journalizeableMainItem = new JournalizeableItem(journalizeableItem, journalizeableItemDetail);

            List<JournalEntryItem> journalizeableItemsBillCodeORPaymentTypeAll = new ArrayList<JournalEntryItem>();
            List<JournalEntryItem> journalizeableItemsBillCodeORPaymentType = getJournalizeableItems(journalizeableMainItem, journalizeable.getAccountDetail(), journalEntryItemComments);
            journalizeableItemsBillCodeORPaymentTypeAll.addAll(journalizeableItemsBillCodeORPaymentType);
            //ArrayList<JournalEntryItem> clearingJournalizeableItemsBillCodeORPaymentType=PostingUtility.getClearingJournalizeableItem(journalizeableItemsBillCodeORPaymentType,primaryCompanyForJournalEntry);
            //journalizeableItemsBillCodeORPaymentTypeAll.addAll(clearingJournalizeableItemsBillCodeORPaymentType);
            //journalizeable.decorateJournalEntryMainItem(totalJournalizeableItems);

            totalJournalizeableItems.addAll(journalizeableItemsBillCodeORPaymentTypeAll);

            totalJournalizeableItems.get(0);

        }
    }

    public List<JournalEntryItem> getJournalizeableItems(JournalizeableItem journalizeableItem, GlAccount accountDetail, String journalEntryComments) {
        IJournalizeableItem thisJournalizeableItem = journalizeableItem.getJournalizeableItem();
        List<JournalEntryItem> journalizeableEntryItems = thisJournalizeableItem.getJournalizeableItems(accountDetail, journalizeableItem.getJournalizeableItemDetail(), journalEntryComments);

        return journalizeableEntryItems;
    }
}
