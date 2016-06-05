package com.core.computism.assasa.persistence.repository.ar;

import com.core.computism.assasa.persistence.entity.ar.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VD on 3/15/2016.
 */
public interface PaymentTypeRepository extends JpaRepository<PaymentType, Long> {
    @Query("from PaymentType p where p.status =:statusId")
    List<PaymentType> getPaymentTypesByStatus(@Param("statusId") Integer statusId);
}
