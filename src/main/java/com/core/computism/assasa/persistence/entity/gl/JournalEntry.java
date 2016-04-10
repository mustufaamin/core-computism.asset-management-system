package com.core.computism.assasa.persistence.entity.gl;

import com.core.computism.assasa.ar.transaction.JournalType;
import com.core.computism.assasa.constant.IJournalEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by VD on 3/9/2016.
 */
@Entity
@Table(name = "ac_journal")
public class JournalEntry extends BaseEntity {

    Logger LOG = LoggerFactory.getLogger(JournalEntry.class);

    private Integer journalType;
    private Integer companyId;
    private Date transactionDate;
    private Date journalizationDate;
    private Integer sourceId;
    private Integer sourceType;
    private Integer subledgerAcctId;
    private Integer subledgerAcctType;
    private BigDecimal total;
    private Integer postId;
    private List<JournalEntryDetail> journalEntryDetails;

    @Column(name = "journal_type")
    public Integer getJournalType() {
        return journalType;
    }

    public void setJournalType(Integer journalType) {
        this.journalType = journalType;
    }

    @Column(name = "company_id")
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Column(name = "transaction_date")
    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Column(name = "journalization_date")
    public Date getJournalizationDate() {
        return journalizationDate;
    }

    public void setJournalizationDate(Date journalizationDate) {
        this.journalizationDate = journalizationDate;
    }

    @Column(name = "source_id")
    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    @Column(name = "source_type")
    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    @Column(name = "subledger_acct_id")
    public Integer getSubledgerAcctId() {
        return subledgerAcctId;
    }

    public void setSubledgerAcctId(Integer subledgerAcctId) {
        this.subledgerAcctId = subledgerAcctId;
    }

    @Column(name = "subledger_acct_type")
    public Integer getSubledgerAcctType() {
        return subledgerAcctType;
    }

    public void setSubledgerAcctType(Integer subledgerAcctType) {
        this.subledgerAcctType = subledgerAcctType;
    }

    @Column(name = "total")
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Column(name = "post_id")
    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    @OneToMany(mappedBy = "journalEntry", cascade = CascadeType.ALL)
    public List<JournalEntryDetail> getJournalEntryDetails() {
        return journalEntryDetails;
    }

    public void setJournalEntryDetails(List<JournalEntryDetail> journalEntryDetails) {
        this.journalEntryDetails = journalEntryDetails;
    }

    @Transient
    public void setSubLedgerAccountType() {
        if(this.getJournalType() == IJournalEntry.JOURNAL_TYPE_AP_PAYMENTS ||
                this.getJournalType() == IJournalEntry.JOURNAL_TYPE_AP_PURCHASES) {
            this.subledgerAcctType = IJournalEntry.SUB_LEDGER_ACCT_TYPE_VENDOR;
        }
        else if(this.getJournalType() == IJournalEntry.JOURNAL_TYPE_AR_SALES ||
                this.getJournalType() == IJournalEntry.JOURNAL_TYPE_AR_RECEIPTS) {
            this.subledgerAcctType = IJournalEntry.SUB_LEDGER_ACCT_TYPE_CUSTOMER;
        }
        else {
            LOG.error("the journal type is not defined. Cannot set a subledger account type ");
        }
    }

    /*public void setEntryTotalNature(int sign)
    {
        try {
            BigDecimal total = new BigDecimal(0.00);
            if(this.getTotal() == null) {
                this.setTotal(new BigDecimal(this.getTotal().doubleValue() * sign));
            } else {
                for(JournalEntryDetail journalEntryDetail : this.getJournalEntryDetails()) {
                    journalEntryDetail.getAmount();
                }
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(),e);
        }
    }*/
}
