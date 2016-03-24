package com.core.computism.assasa.persistence.repository.ar;

import com.core.computism.assasa.persistence.entity.ar.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by VD on 3/19/2016.
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
