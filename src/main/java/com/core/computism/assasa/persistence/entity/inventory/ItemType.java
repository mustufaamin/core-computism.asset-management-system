package com.core.computism.assasa.persistence.entity.inventory;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

/**
 * Created by VD on 2/9/2016.
 */
@Entity
@Table(name = "item_type")
public class ItemType extends BaseEntity {

    private String name;
    private Collection<Item> itemsById;

    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "itemType")
    public Collection<Item> getItemsById() {
        return itemsById;
    }

    public void setItemsById(Collection<Item> itemsById) {
        this.itemsById = itemsById;
    }
}
