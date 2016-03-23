package com.core.computism.assasa.persistence.repository.inventory;

import com.core.computism.assasa.persistence.entity.pos.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by VD on 2/28/2016.
 */
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
