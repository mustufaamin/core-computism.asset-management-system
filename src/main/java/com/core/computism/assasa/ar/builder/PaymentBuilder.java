package com.core.computism.assasa.ar.builder;

import com.core.computism.assasa.ar.dto.AdjustmentDto;
import com.core.computism.assasa.ar.dto.PaymentDto;
import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.persistence.entity.ar.Adjustment;
import com.core.computism.assasa.persistence.entity.ar.Payment;
import com.core.computism.assasa.persistence.entity.ar.PaymentType;
import com.core.computism.assasa.persistence.entity.ar.account.ArAccount;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by VD on 3/6/2016.
 */
public class PaymentBuilder {

    private ArAccount arAccount;
    private Integer referenceArAccountId;
    private PaymentType paymentType;
    private BigDecimal paymentAmount;
    private Date paymentDate;
    private Date postedDate;
    private Integer processedBy;
    private String description;
    private String note;
    private Integer status;
    private Integer createdBy;
    private Integer modifiedBy;
    private Integer batchId;
    private Integer source;
    private Boolean suppressOnStatement;
    private String statementDescription2;
    private Integer referenceId;

    public PaymentBuilder setArAccount(ArAccount arAccount) {
        this.arAccount = arAccount;
        return this;
    }

    public PaymentBuilder setReferenceArAccountId(Integer referenceArAccountId) {
        this.referenceArAccountId = referenceArAccountId;
        return this;
    }

    public PaymentBuilder setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
        return this;
    }

    public PaymentBuilder setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
        return this;
    }

    public PaymentBuilder setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
        return this;
    }

    public PaymentBuilder setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
        return this;
    }

    public PaymentBuilder setProcessedBy(Integer processedBy) {
        this.processedBy = processedBy;
        return this;
    }

    public PaymentBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public PaymentBuilder setNote(String note) {
        this.note = note;
        return this;
    }

    public PaymentBuilder setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public PaymentBuilder setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public PaymentBuilder setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public PaymentBuilder setBatchId(Integer batchId) {
        this.batchId = batchId;
        return this;
    }

    public PaymentBuilder setSource(Integer source) {
        this.source = source;
        return this;
    }

    public PaymentBuilder setSuppressOnStatement(Boolean suppressOnStatement) {
        this.suppressOnStatement = suppressOnStatement;
        return this;
    }

    public PaymentBuilder setStatementDescription2(String statementDescription2) {
        this.statementDescription2 = statementDescription2;
        return this;
    }

    public PaymentBuilder setReferenceId(Integer referenceId) {
        this.referenceId = referenceId;
        return this;
    }

    public ArAccount getArAccount() {
        return arAccount;
    }

    public Integer getReferenceArAccountId() {
        return referenceArAccountId;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public Integer getProcessedBy() {
        return processedBy;
    }

    public String getDescription() {
        return description;
    }

    public String getNote() {
        return note;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public Integer getSource() {
        return source;
    }

    public Boolean getSuppressOnStatement() {
        return suppressOnStatement;
    }

    public String getStatementDescription2() {
        return statementDescription2;
    }

    public Integer getReferenceId() {
        return referenceId;
    }

    public Payment build() {

        Payment payment = new Payment();
        payment.setArAccount(this.getArAccount());
        payment.setReferenceArAccountId(this.getReferenceArAccountId());
        payment.setPaymentType(this.getPaymentType());
        payment.setPaymentAmount(this.getPaymentAmount());
        payment.setPaymentDate(this.getPaymentDate());
        payment.setPostedDate(this.getPostedDate());
        payment.setProcessedBy(this.getProcessedBy());
        payment.setDescription(this.getDescription());
        payment.setNote(this.getNote());
        payment.setStatus(this.getStatus());
        payment.setCreatedBy(this.getCreatedBy());
        payment.setModifiedBy(this.getModifiedBy());
        payment.setBatchId(this.getBatchId());
        payment.setSource(this.getSource());
        payment.setSuppressOnStatement(this.getSuppressOnStatement());
        payment.setStatementDescription2(this.getStatementDescription2());
        payment.setReferenceId(this.getReferenceId());

        return payment;
    }

    public List<PaymentDto> buildPaymentDtoList(List<Payment> payments) throws BuilderException {
        if(payments == null || payments.size() < 1){
            throw new BuilderException("Unable to build Payment DTO List for [null] payment or empty.");
        }

        List<PaymentDto> paymentDTOs = new ArrayList<>();

        for(Payment payment : payments){
            paymentDTOs.add(buildPaymentDto(payment));
        }
        return paymentDTOs;
    }

    public PaymentDto buildPaymentDto(Payment payment) throws BuilderException {

        if(payment == null){
            throw new BuilderException("Payment Entity not found");
        }

        PaymentDto paymentDto = new PaymentDto();

        paymentDto.setArAccountId(payment.getArAccount().getId());
        paymentDto.setReferenceArAccountId(payment.getReferenceArAccountId());
        paymentDto.setPaymentTypeId(payment.getPaymentType().getId());
        paymentDto.setPaymentAmount(payment.getPaymentAmount());
        paymentDto.setPaymentDate(payment.getPaymentDate());
        paymentDto.setPostedDate(payment.getPostedDate());
        paymentDto.setProcessedBy(payment.getProcessedBy());
        paymentDto.setDescription(payment.getDescription());
        paymentDto.setNote(payment.getNote());
        paymentDto.setStatus(payment.getStatus());
        paymentDto.setCreatedBy(payment.getCreatedBy());
        paymentDto.setModifiedBy(payment.getModifiedBy());
        paymentDto.setBatchId(payment.getBatchId());
        paymentDto.setSource(payment.getSource());
        paymentDto.setSuppressOnStatement(payment.getSuppressOnStatement());
        paymentDto.setStatementDescription2(payment.getStatementDescription2());
        paymentDto.setReferenceId(payment.getReferenceId());

        return paymentDto;
    }
}
