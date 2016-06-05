package com.core.computism.assasa.persistence.repository.ar;

import com.core.computism.assasa.persistence.entity.ar.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VD on 3/6/2016.
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query("from Payment p where p.arAccount.customer.id =:customerId")
    List<Payment> getPaymentByCustomerId(@Param("customerId") Long customerId);
}
