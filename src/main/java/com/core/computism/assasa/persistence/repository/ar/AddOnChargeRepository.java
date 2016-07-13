package com.core.computism.assasa.persistence.repository.ar;

import com.core.computism.assasa.persistence.entity.ar.billing.AddOnCharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VD on 7/12/2016.
 */
public interface AddOnChargeRepository extends JpaRepository<AddOnCharge,Long> {
    @Query("from AddOnCharge a where a.status= :addOnChargeStatus")
    List<AddOnCharge> findAddOnChargesByStatus(@Param("addOnChargeStatus") Integer addOnChargeStatus);
}
