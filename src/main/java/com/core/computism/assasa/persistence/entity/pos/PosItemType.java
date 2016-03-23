package com.core.computism.assasa.persistence.entity.pos;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;
import java.util.List;

/**
 * Created by VD on 2/9/2016.
 */
@Entity
@Table(name = "pos_item_type")
public class PosItemType extends BaseEntity {

    private String name;
    private List<PosItem> itemsById;

    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "posItemType")
    public List<PosItem> getItemsById() {
        return itemsById;
    }

    public void setItemsById(List<PosItem> itemsById) {
        this.itemsById = itemsById;
    }
}
