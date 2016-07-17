package com.core.computism.assasa.persistence.entity.ar.billing;

import com.core.computism.assasa.persistence.entity.pos.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by VD on 7/11/2016.
 */
@Entity
@Table(name = "bi_add_on_group_detail")
public class AddOnGroupDetail extends BaseEntity {

    private AddOnCharge addOnCharge;
    private AddOnGroup addOnGroup;

    public AddOnGroupDetail() {}

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "add_on_group_id")
    public AddOnGroup getAddOnGroup() {
        return addOnGroup;
    }

    public void setAddOnGroup(AddOnGroup addOnGroup) {
        this.addOnGroup = addOnGroup;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "add_on_charge_id")
    public AddOnCharge getAddOnCharge() {
        return addOnCharge;
    }

    public void setAddOnCharge(AddOnCharge addOnCharge) {
        this.addOnCharge = addOnCharge;
    }
}
