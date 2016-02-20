package com.core.computism.assasa.persistence.entity.inventory;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by VD on 2/9/2016.
 */
@Entity
@Table(name = "item")
public class Item extends BaseEntity {
    private String itemNumber;
    private String itemUnit;
    private Integer stockLevel;
    private Integer minStockLevel;
    private String costPrice;
    private String salesPrice;
    private String location;
    private String itemDescription;
    private ItemType itemType;
    private Supplier supplierRef;


    @Basic
    @Column(name = "item_number", nullable = false, insertable = true, updatable = true, length = 255)
    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    @Basic
    @Column(name = "item_unit", nullable = false, insertable = true, updatable = true, length = 255)
    public String getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }

    @Basic
    @Column(name = "stock_level", nullable = false, insertable = true, updatable = true)
    public Integer getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(Integer stockLevel) {
        this.stockLevel = stockLevel;
    }

    @Basic
    @Column(name = "min_stock_level", nullable = false, insertable = true, updatable = true)
    public Integer getMinStockLevel() {
        return minStockLevel;
    }

    public void setMinStockLevel(Integer minStockLevel) {
        this.minStockLevel = minStockLevel;
    }

    @Basic
    @Column(name = "cost_price", nullable = true, insertable = true, updatable = true, length = 45)
    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    @Basic
    @Column(name = "sales_price", nullable = true, insertable = true, updatable = true, length = 45)
    public String getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(String salesPrice) {
        this.salesPrice = salesPrice;
    }

    @Basic
    @Column(name = "location", nullable = true, insertable = true, updatable = true, length = 45)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "item_description", nullable = true, insertable = true, updatable = true, length = 45)
    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }


    @ManyToOne
    @JoinColumn(name = "item_type", referencedColumnName = "id", nullable = false)

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }


    @ManyToOne
    @JoinColumn(name = "supplier_ref", referencedColumnName = "id", nullable = false)

    public Supplier getSupplierRef() {
        return supplierRef;
    }

    public void setSupplierRef(Supplier supplierRef) {
        this.supplierRef = supplierRef;
    }
}
