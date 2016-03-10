package com.core.computism.assasa.inventory.domain;

import com.core.computism.assasa.persistence.entity.inventory.Currency;
import com.core.computism.assasa.persistence.entity.inventory.Customer;

import java.util.List;

/**
 * Created by VD on 3/10/2016.
 */
public class OrderDto {

    private Integer invoiceNumber;
    private Integer batchNumber;
    private Integer totalAmount;
    private Integer numberOfItems;
    private Long customerId;
    private Long currencyId;

    List<ItemDto> orderItems;

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

    public List<ItemDto> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<ItemDto> orderItems) {
        this.orderItems = orderItems;
    }
}
