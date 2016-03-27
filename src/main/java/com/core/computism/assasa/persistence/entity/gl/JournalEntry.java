package com.core.computism.assasa.persistence.entity.gl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by VD on 3/9/2016.
 */
@Entity
@Table(name = "ac_journal")
public class JournalEntry extends BaseEntity {

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
}
