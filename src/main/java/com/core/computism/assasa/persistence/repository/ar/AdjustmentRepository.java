package com.core.computism.assasa.persistence.repository.ar;

import com.core.computism.assasa.persistence.entity.ar.Adjustment;
import com.core.computism.assasa.persistence.entity.ar.Payment;
import com.core.computism.assasa.persistence.entity.cmn.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VD on 3/6/2016.
 */
public interface AdjustmentRepository extends JpaRepository<Adjustment, Long> {
    @Query("from Adjustment a where a.arAccount.id =:arAccountId")
    List<Adjustment> searchAdjustment(@Param("arAccountId") Integer arAccountId);
}
