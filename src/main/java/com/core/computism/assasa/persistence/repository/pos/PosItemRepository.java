package com.core.computism.assasa.persistence.repository.pos;

import com.core.computism.assasa.persistence.entity.pos.PosItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VD on 2/19/2016.
 */
public interface PosItemRepository extends JpaRepository<PosItem,Long> {

    @Query(" from PosItem pi where pi.id in :itemIds")
    List<PosItem> findItemsByIds(@Param("itemIds")List<Long> itemIds);

    @Query(" from PosItem pi where pi.itemCode = :itemCode" )
    PosItem findItemByCode(@Param("itemCode")String itemCode);
}

