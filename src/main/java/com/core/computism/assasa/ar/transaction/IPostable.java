package com.core.computism.assasa.ar.transaction;


import com.core.computism.assasa.persistence.entity.gl.JournalEntry;

import java.math.BigDecimal;
import java.util.Date;

public interface IPostable {

    public Integer getArAccountId();

    public Long getArTransactionReferenceId();

    public Date getArTransactionDate();

    public int getArTransactionSourceId();

    public int getArTransactionType();

    public BigDecimal getArTransactionAmount();

    public String getArTransactionStatementDescription1();

    public String getArTransactionStatementDescription2();

    public String getArTransactionInternalDescription();

    public int getGlAccountId();

    public JournalEntry getJournalEntry();

    public int getArTransactionSubType();

    public Boolean getSuppressOnStatement();

    public void setStatus(Integer status);
}