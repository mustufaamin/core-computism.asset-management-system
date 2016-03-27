package com.core.computism.assasa.persistence.entity.gl;

import com.core.computism.assasa.persistence.entity.ar.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by VD on 3/25/2016.
 */
@Entity
@Table(name = "ac_journal_detail")
public class JournalEntryDetail extends BaseEntity {

    private Integer journalId;
    private Integer glAccountId;
    private BigDecimal amount;
    private String comment;
    private BigDecimal quantity;

    @Column(name = "journal_id")
    public Integer getJournalId() {
        return journalId;
    }

    public void setJournalId(Integer journalId) {
        this.journalId = journalId;
    }

    @Column(name = "gl_account_id")
    public Integer getGlAccountId() {
        return glAccountId;
    }

    public void setGlAccountId(Integer glAccountId) {
        this.glAccountId = glAccountId;
    }

    @Column(name = "amount")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Column(name = "quantity")
    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}
