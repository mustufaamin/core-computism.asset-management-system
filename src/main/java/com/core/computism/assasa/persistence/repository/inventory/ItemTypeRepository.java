package com.core.computism.assasa.persistence.repository.inventory;

import com.core.computism.assasa.persistence.entity.inventory.Item;
import com.core.computism.assasa.persistence.entity.inventory.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by VD on 2/24/2016.
 */
public interface ItemTypeRepository extends JpaRepository<ItemType,Long> {
}
