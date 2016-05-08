package com.core.computism.assasa.persistence.entity.pos;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by M.Mustafa Amin Shah on 2/9/2016.
 */
@Entity
@Table(name = "pos_item")
public class PosItem extends BaseEntity {
    private String itemCode;
    private String itemUnit;
    private Integer stockLevel;
    private Integer minStockLevel;
    private String costPrice;
    private String salesPrice;
    private String location;
    private String itemDescription;
    private String color;
    private String size;
    private PosItemType posItemType;
    private Supplier supplier;
    private PosItemGroup posItemGroup;

    @Basic
    @Column(name = "item_code", nullable = false, insertable = true, updatable = true, length = 255)
    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemNumber) {
        this.itemCode = itemNumber;
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

    @Column(name = "color", nullable = true, insertable = true, updatable = true, length = 45)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Column(name = "size", nullable = true, insertable = true, updatable = true)
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @ManyToOne
    @JoinColumn(name = "item_type", referencedColumnName = "id", nullable = false)
    public PosItemType getPosItemType() {
        return posItemType;
    }

    public void setPosItemType(PosItemType posItemType) {
        this.posItemType = posItemType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_ref", referencedColumnName = "id")
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_group_id", referencedColumnName = "id", nullable = false)
    public PosItemGroup getPosItemGroup() {
        return posItemGroup;
    }

    public void setPosItemGroup(PosItemGroup posItemGroup) {
        this.posItemGroup = posItemGroup;
    }
}
