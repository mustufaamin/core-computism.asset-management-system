package com.core.computism.assasa.persistence.repository.customer;

import com.core.computism.assasa.persistence.entity.customer.Customer;
import com.core.computism.assasa.persistence.entity.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by VD on 5/23/2016.
 */
public interface CustomerTypeRepository extends JpaRepository<CustomerType,Long> {
}
