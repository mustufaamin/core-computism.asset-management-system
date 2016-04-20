package com.core.computism.assasa.persistence.repository.pos;

import com.core.computism.assasa.persistence.entity.cmn.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by VD on 2/28/2016.
 */
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
