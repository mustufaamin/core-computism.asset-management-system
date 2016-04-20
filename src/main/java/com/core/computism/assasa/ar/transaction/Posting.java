package com.core.computism.assasa.ar.transaction;

import com.core.computism.assasa.ar.IJournalizeableItem;
import com.core.computism.assasa.ar.dto.service.IJournalizeable;
import com.core.computism.assasa.ar.dto.service.JournalEntryItem;
import com.core.computism.assasa.ar.dto.service.JournalizeableItem;
import com.core.computism.assasa.ar.dto.service.JournalizeableItemDetail;
import com.core.computism.assasa.ar.dto.service.TransactionServiceDto;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.persistence.entity.gl.JournalEntry;
import com.core.computism.assasa.persistence.entity.gl.JournalEntryDetail;
import com.core.computism.assasa.persistence.entity.gl.admin.GlAccount;
import com.core.computism.assasa.persistence.repository.gl.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by VD on 3/8/2016.
 */
@Component
public class Posting {

    private List<? extends IPostable> postingList;

    @Autowired
    TransactionServiceDto transactionServiceDto;

    @Autowired
    JournalEntryRepository journalEntryRepository;


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
                transactionService.doPost(this, postingList, new Date(), transactionTypeId, createdBy, companyId);
                break;
            }
        }
    }

    /*public void journalTransactions(List<? extends IJournalizeable> journalizeables, String transactionDate) throws ArBusinessException {
        Date journalTransactionDate= null;
        ArrayList<JournalEntry> JEs=new ArrayList<JournalEntry>();
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

            JournalEntry primaryCompanyJournalEntry= getJournalEntry(journalizeable, journalTransactionDate, primaryCompanyForJournalEntry,totalJournalizeableItems);
            primaryCompanyJournalEntry.setTotal(journalizeable.getJournalizeableMainItemAmount());
            //journalizeable.decorateJournalEntry(primaryCompanyJournalEntry);
            journalizeable.setJournalEntry(primaryCompanyJournalEntry);
            JEs.add(primaryCompanyJournalEntry);

        }
    }*/

    public void journalTransactions(List<? extends IJournalizeable> journalizeables, Date transactionDate, int companyId) throws ArBusinessException {
        ArrayList<JournalEntry> JEs = new ArrayList<JournalEntry>();
        for (IJournalizeable journalizeable : journalizeables) {
            List<JournalEntryItem> totalJournalizeableItems = new ArrayList<>();
            String journalEntryItemComments = journalizeable.getSubLedgerAccountName();

            BigDecimal mainItemAmount = journalizeable.getJournalizeableMainItemAmount();
            BigDecimal mainItemQuantity = journalizeable.getJournalizeableMainItemQuantity();

            //Bill-code or Payment type
            IJournalizeableItem journalizeableItem = journalizeable.getJournalizeableMainItem();
            JournalizeableItemDetail journalizeableMainItemDetail = new JournalizeableItemDetail(mainItemAmount, mainItemQuantity);
            JournalizeableItem journalizeableMainItem = new JournalizeableItem(journalizeableItem, journalizeableMainItemDetail);
            String mainItemDescription = journalizeableItem.getJournalizeableItemName();
            List<JournalEntryItem> journalEntryMainItems = getJournalizeableItems(journalizeableMainItem, journalizeableItem.getAccountDetail(), (mainItemDescription + " / " + journalEntryItemComments));

            BigDecimal entryTotalAmount = PostingUtility.entryTotalAmount(totalJournalizeableItems);

            //Ar Account Type / Control Account
            IJournalizeableItem ijournalizeableControlItem = journalizeable.getJournalizeableControlItem();
            JournalizeableItemDetail journalizeableControlItemDetail = new JournalizeableItemDetail(new BigDecimal(0.00), new BigDecimal(0.00));
            JournalizeableItem journalizeableControlItem = new JournalizeableItem(journalizeableItem, journalizeableControlItemDetail);
            String controlItemDescription = ijournalizeableControlItem.getJournalizeableItemName();
            List<JournalEntryItem> journalEntryControlItems = getJournalizeableItems(journalizeableControlItem, ijournalizeableControlItem.getAccountDetail(), (controlItemDescription + " / " + journalEntryItemComments));

            PostingUtility.offSetJournalEntryItem(journalEntryMainItems, journalEntryControlItems.get(0));

            totalJournalizeableItems.addAll(journalEntryMainItems);
            totalJournalizeableItems.addAll(journalEntryControlItems);

            JournalEntry journalEntry = getJournalEntry(journalizeable, transactionDate, companyId, totalJournalizeableItems);
            journalEntry.setTotal(entryTotalAmount);
            journalizeable.setJournalEntry(journalEntry);
            JEs.add(journalEntry);
        }
        journalEntryRepository.save(JEs);
    }

    private JournalEntry getJournalEntry(IJournalizeable journalizeable, Date journalDate, int companyId, List<JournalEntryItem> totalJournalizeableItems) {
        JournalEntry journalEntry =
                getFactoryJournalEntry(journalizeable.getJournalType(), journalDate, journalizeable.getJournalTransactionDate(),
                        journalizeable.getJournalSourceId(), journalizeable.getJournalSourceType(), journalizeable.getSubLedgerAccountId(), companyId, totalJournalizeableItems);
        return journalEntry;
    }

    public List<JournalEntryItem> getJournalizeableItems(JournalizeableItem journalizeableItem, GlAccount accountDetail, String journalEntryComments) {
        IJournalizeableItem thisJournalizeableItem = journalizeableItem.getJournalizeableItem();
        List<JournalEntryItem> journalizeableEntryItems = thisJournalizeableItem.getJournalizeableItems(accountDetail, journalizeableItem.getJournalizeableItemDetail(), journalEntryComments);

        return journalizeableEntryItems;
    }

    public JournalEntry getFactoryJournalEntry(int journalType, Date journalDate, Date journalTransactionDate, int journalSourceId,
                                               int journalSourceType, int subledgerAcctountId, int companyId, List<JournalEntryItem> journalEntryItems) {
        JournalEntry journalEntry = new JournalEntry();
        journalEntry.setCompanyId(companyId);
        journalEntry.setJournalType(journalType);
        journalEntry.setJournalizationDate(journalDate);
        journalEntry.setTransactionDate(journalTransactionDate);
        journalEntry.setSourceId(journalSourceId);
        journalEntry.setSourceType(journalSourceType);
        journalEntry.setSubledgerAcctId(subledgerAcctountId);
        journalEntry.setSubLedgerAccountType();
        List<JournalEntryDetail> journalEntryDetails = getJournalEntryDetails(journalEntry, journalEntryItems);
        journalEntry.setJournalEntryDetails(journalEntryDetails);
        return journalEntry;
    }

    private List<JournalEntryDetail> getJournalEntryDetails(JournalEntry journalEntry, List<JournalEntryItem> journalEntryItems) {
        List<JournalEntryDetail> journalEntryDetails = new ArrayList<>();
        for (JournalEntryItem journalEntryItem : journalEntryItems) {
            JournalEntryDetail journalEntryDetail = new JournalEntryDetail();
            journalEntryDetail.setAmount(journalEntryItem.getAmount());
            journalEntryDetail.setComment(journalEntryItem.getComment());
            journalEntryDetail.setGlAccountId(journalEntryItem.getAccountDetail().getId().intValue());
            journalEntryDetail.setJournalEntry(journalEntry);
            journalEntryDetail.setQuantity(journalEntryItem.getQuantity());
            /*if(journalEntryItem.isDebit()) {
                journalEntry.setTotal(journalEntryItem.getAmount());
            }*/
            journalEntryDetails.add(journalEntryDetail);
        }
        return journalEntryDetails;
    }
}
