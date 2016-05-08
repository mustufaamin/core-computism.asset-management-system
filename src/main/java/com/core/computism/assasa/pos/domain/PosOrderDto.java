package com.core.computism.assasa.pos.domain;

import com.core.computism.assasa.pos.domain.type.PosOrderStatus;

import java.util.List;

/**
 * Created by VD on 4/10/2016.
 */
public class PosOrderDto {
    private Long id;
    private Long invoiceNumber;
    private Long batchNumber;
    private Double totalAmount;
    private Integer numberOfItems;
    private PosOrderStatus posOrderStatus;

    private Long customerId;
    private Long currencyId;
    List<PosOrderItemDto> items;
    List<PosPaymentDto> posPaymentDtos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Long invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Long getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(Long batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
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

    public List<PosOrderItemDto> getItems() {
        return items;
    }

    public void setItems(List<PosOrderItemDto> items) {
        this.items = items;
    }

    public List<PosPaymentDto> getPosPaymentDtos() {
        return posPaymentDtos;
    }

    public void setPosPaymentDtos(List<PosPaymentDto> posPaymentDtos) {
        this.posPaymentDtos = posPaymentDtos;
    }

    public PosOrderStatus getPosOrderStatus() {
        return posOrderStatus;
    }

    public void setPosOrderStatus(PosOrderStatus posOrderStatus) {
        this.posOrderStatus = posOrderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PosOrderDto that = (PosOrderDto) o;

        if (batchNumber != null ? !batchNumber.equals(that.batchNumber) : that.batchNumber != null) return false;
        if (currencyId != null ? !currencyId.equals(that.currencyId) : that.currencyId != null) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (invoiceNumber != null ? !invoiceNumber.equals(that.invoiceNumber) : that.invoiceNumber != null)
            return false;
        if (items != null ? !items.equals(that.items) : that.items != null) return false;
        if (numberOfItems != null ? !numberOfItems.equals(that.numberOfItems) : that.numberOfItems != null)
            return false;
        if (posPaymentDtos != null ? !posPaymentDtos.equals(that.posPaymentDtos) : that.posPaymentDtos != null)
            return false;
        if (totalAmount != null ? !totalAmount.equals(that.totalAmount) : that.totalAmount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (invoiceNumber != null ? invoiceNumber.hashCode() : 0);
        result = 31 * result + (batchNumber != null ? batchNumber.hashCode() : 0);
        result = 31 * result + (totalAmount != null ? totalAmount.hashCode() : 0);
        result = 31 * result + (numberOfItems != null ? numberOfItems.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (currencyId != null ? currencyId.hashCode() : 0);
        result = 31 * result + (items != null ? items.hashCode() : 0);
        result = 31 * result + (posPaymentDtos != null ? posPaymentDtos.hashCode() : 0);
        return result;
    }
}
