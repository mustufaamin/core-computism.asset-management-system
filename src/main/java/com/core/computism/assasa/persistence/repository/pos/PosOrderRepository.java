package com.core.computism.assasa.persistence.repository.pos;

import com.core.computism.assasa.persistence.entity.pos.PosOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by VD on 4/13/2016.
 */
public interface PosOrderRepository extends JpaRepository<PosOrder,Long> {
    @Query("Select max(po.invoiceNumber) from PosOrder po")
    Long findCurrentInvoiceNumber();

    @Query("Select max(po.batchNumber) from PosOrder po")
    Long findCurrentBatchNumber();
}
