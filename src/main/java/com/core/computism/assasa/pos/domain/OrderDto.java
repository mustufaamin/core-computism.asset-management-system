package com.core.computism.assasa.pos.domain;

import java.util.List;

/**
 * Created by VD on 4/10/2016.
 */
public class OrderDto {
    private Integer invoiceNumber;
    private Integer batchNumber;
    private Integer totalAmount;
    private Integer numberOfItems;

    private Long customerId;
    private Long currencyId;
    List<Long> items;
    List<PosPaymentDto> posPaymentDtos;

    public Integer getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Integer invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Integer getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(Integer batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public List<Long> getItems() {
        return items;
    }

    public void setItems(List<Long> items) {
        this.items = items;
    }

    public List<PosPaymentDto> getPosPaymentDtos() {
        return posPaymentDtos;
    }

    public void setPosPaymentDtos(List<PosPaymentDto> posPaymentDtos) {
        this.posPaymentDtos = posPaymentDtos;
    }
}
