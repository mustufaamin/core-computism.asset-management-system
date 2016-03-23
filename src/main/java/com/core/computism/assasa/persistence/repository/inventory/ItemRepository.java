package com.core.computism.assasa.persistence.repository.inventory;

import com.core.computism.assasa.persistence.entity.pos.PosItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by VD on 2/19/2016.
 */
public interface ItemRepository extends JpaRepository<PosItem,Long> {
}
