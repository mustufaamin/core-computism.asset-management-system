package com.core.computism.assasa.ar.service.impl;

import com.core.computism.assasa.ar.dto.ArTransactionSearchResponseDto;
import com.core.computism.assasa.ar.service.ArAccountService;
import com.core.computism.assasa.ar.service.TransactionService;
import com.core.computism.assasa.ar.transaction.IPostable;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.persistence.entity.ar.Transaction;
import com.core.computism.assasa.persistence.entity.ar.account.ArAccount;
import com.core.computism.assasa.persistence.entity.customer.Customer;
import com.core.computism.assasa.persistence.repository.ar.ArAccountRepository;
import com.core.computism.assasa.persistence.repository.ar.TransactionRepository;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by VD on 3/19/2016.
 */
@Service(value = "transactionService")
public class TransactionServiceImpl implements TransactionService {

    public final static int INT_ACTIVE = 1;
    public final static int INT_INACTIVE = 2;
    public final static int INT_DRAFT = 3;
    public final static int INT_DELETED = 0;

    public final static int UNBILLED = 1;
    public final static int BILLED = 2;

    Logger LOG = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    ArAccountRepository arAccountRepository;

    @Autowired
    ArAccountService arAccountService;

    @Override
    public List<Transaction> populateTransaction(List<? extends IPostable> postingObjectsSubList, Date transactionDate,
                                                 int transactionTypeId, int createdBy) throws ArBusinessException {
        List<Transaction> transactions = new ArrayList<>();
        try {
            int recordCount = 0;
            BigDecimal totalTransactionAmount = new BigDecimal(0.00);
            BigDecimal totalAddOnAmount = new BigDecimal(0.00);

            for (IPostable po : postingObjectsSubList) {
                Transaction trans = new Transaction();
                recordCount++;

                ArAccount baseAcc = arAccountRepository.findOne(po.getArAccountId().longValue());
                if (baseAcc == null) {
                    throw new ArBusinessException("Unable to find Ar Account.");
                }

                Customer customer = baseAcc.getCustomer();
                if (customer == null) {
                    throw new ArBusinessException("Unable to find customer.");
                }

                LOG.debug("po.getCustomerId():" + customer.getId());

                trans.setChargeCustomerId(baseAcc.getCustomer().getId().intValue());
                trans.setStatementId(0);
                if (trans.getChargeCustomerId().equals(0)) {
                    throw new ArBusinessException("Charge customer id is not set.");
                }
                if (baseAcc != null && po.getArAccountId() == 0) {
                    throw new ArBusinessException("Could not find account id of bill to customer id " + customer.getId());
                }
                trans.setArAccountId(po.getArAccountId());
                trans.setTransactionDate(po.getArTransactionDate());
                /*checking if account is active for posting.*/
                baseAcc = arAccountRepository.findOne(trans.getArAccountId().longValue());

                if (baseAcc.getAccountStatus() != INT_ACTIVE) {
                    throw new ArBusinessException("Posting is Not Allowed on Inactive Ar Account " + customer.getId() + ".");
                }
                if (baseAcc.getActivationDate().equals("")) {
                    throw new ArBusinessException("AR Account activation date is not correct");
                }
                if (po.getArTransactionDate().before(baseAcc.getActivationDate())) {
                    throw new ArBusinessException("Customer (" + customer.getId() + ") activation date is greater than System Date (" + transactionDate + ").");
                }
                trans.setReferenceId(po.getArTransactionReferenceId().intValue());
                trans.setPostingDate(new Date(System.currentTimeMillis()));

                trans.setTransactionType(transactionTypeId);
                trans.setTransactionSubType(po.getArTransactionSubType());

                trans.setAmount(po.getArTransactionAmount());
                totalTransactionAmount = po.getArTransactionAmount(); // TODO need to use po.getARTransactionTotalAmount();
                trans.setStatus(UNBILLED); // 1 designate unbilled charges - Statement did not billed yet
                trans.setStatementDescription1(po.getArTransactionStatementDescription1());
                trans.setStatementDescription2(po.getArTransactionStatementDescription2());
                trans.setDescription(po.getArTransactionInternalDescription());
                trans.setGlAccountId(po.getGlAccountId());
                trans.setJournalEntry(po.getJournalEntry());
                trans.setCreatedBy(createdBy);
                trans.setSuppressOnStatement(po.getSuppressOnStatement());

                //TODO After Umer bhai demo will start work on AddOn transaction
                totalTransactionAmount.add(totalAddOnAmount);
                trans.setTotalAmount(totalTransactionAmount); // added for transaction balance
                transactions.add(trans);
            }
        } catch (ArBusinessException ex) {
            LOG.error(ex.getMessage(), ex);
        }
        return transactions;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
    public List<ArTransactionSearchResponseDto> getArTransactions() throws ArBusinessException {
        List<ArTransactionSearchResponseDto> arTransactionSearchResponseDtos = new ArrayList<>();
        List<Transaction> transactions = transactionRepository.findAll();
        if (CollectionUtils.isEmpty(transactions)) {
            throw new ArBusinessException("Ar Transactions does not exist.");
        }

        for (Transaction transaction : transactions) {
            ArAccount arAccount = arAccountService.getArAccountById(transaction.getArAccountId().longValue());
            ArTransactionSearchResponseDto arAccountSearchResponseDto = new ArTransactionSearchResponseDto(transaction, arAccount);
            arTransactionSearchResponseDtos.add(arAccountSearchResponseDto);
        }
        return arTransactionSearchResponseDtos;
    }
}
