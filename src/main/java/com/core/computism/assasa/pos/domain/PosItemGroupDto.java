package com.core.computism.assasa.pos.domain;

import com.core.computism.assasa.persistence.entity.ar.billing.BillCode;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Created by M.Mustafa Amin Shah on 3/27/2016.
 */
@JsonAutoDetect
public class PosItemGroupDto {

    private Long id;
    private String groupName;
    private String groupDescription;
    private Byte itemGroupStatus;
    private Long billCodeId;
    private String billCodeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public Byte getItemGroupStatus() {
        return itemGroupStatus;
    }

    public void setItemGroupStatus(Byte itemGroupStatus) {
        this.itemGroupStatus = itemGroupStatus;
    }

    public Long getBillCodeId() {
        return billCodeId;
    }

    public void setBillCodeId(Long billCodeId) {
        this.billCodeId = billCodeId;
    }

    public String getBillCodeName() {
        return billCodeName;
    }

    public void setBillCodeName(String billCodeName) {
        this.billCodeName = billCodeName;
    }
}
