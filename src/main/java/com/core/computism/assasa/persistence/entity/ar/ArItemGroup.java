package com.core.computism.assasa.persistence.entity.ar;

import com.core.computism.assasa.persistence.entity.ar.billing.BillCode;
import com.core.computism.assasa.persistence.entity.pos.PosItem;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by VD on 5/22/2016.
 */
@Entity
@Table(name = "ar_item_group", schema = "", catalog = "assasa")
public class ArItemGroup extends BaseEntity{

    private String groupName;
    private String groupDescription;
    private Byte itemGroupStatus;


    private BillCode billCode;




    @Basic
    @Column(name = "group_name", nullable = true, insertable = true, updatable = true, length = 55)
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Basic
    @Column(name = "group_description", nullable = true, insertable = true, updatable = true, length = 255)
    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    @Basic
    @Column(name = "item_group_status", nullable = true, insertable = true, updatable = true)
    public Byte getItemGroupStatus() {
        return itemGroupStatus;
    }

    public void setItemGroupStatus(Byte itemGroupStatus) {
        this.itemGroupStatus = itemGroupStatus;
    }

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "bill_code_id")
    public BillCode getBillCode() {
        return billCode;
    }

    public void setBillCode(BillCode billCode) {
        this.billCode = billCode;
    }
}
