package com.core.computism.assasa.persistence.repository.ar;

import com.core.computism.assasa.persistence.entity.ar.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by VD on 3/6/2016.
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
