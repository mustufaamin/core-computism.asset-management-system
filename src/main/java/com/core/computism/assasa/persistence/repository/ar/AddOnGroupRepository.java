package com.core.computism.assasa.persistence.repository.ar;

import com.core.computism.assasa.persistence.entity.ar.billing.AddOnCharge;
import com.core.computism.assasa.persistence.entity.ar.billing.AddOnGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VD on 7/12/2016.
 */
public interface AddOnGroupRepository extends JpaRepository<AddOnGroup,Long> {
    @Query("from AddOnGroup a where a.status= :addOnGroupStatus")
    List<AddOnGroup> findAddOnGroupsByStatus(@Param("addOnGroupStatus") Integer addOnChargeStatus);
}
