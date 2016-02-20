package com.core.computism.assasa.persistence.entity.inventory;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;
import java.util.List;

/**
 * Created by VD on 2/9/2016.
 */
@Entity
@Table(name = "currency")
public class Currency extends BaseEntity {

    private String name;
    private String symbol;
    private List<Order> orders;
    private List<PurchaseOrder> purchaseOrders;

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "symbol", nullable = false, insertable = true, updatable = true, length = 3)
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @OneToMany(mappedBy = "currency",fetch = FetchType.LAZY)
    public List<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }

    public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "currency")
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
