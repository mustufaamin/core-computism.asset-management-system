package com.core.computism.assasa.persistence.repository.inventory;

import com.core.computism.assasa.persistence.entity.inventory.Customer;
import com.core.computism.assasa.persistence.entity.inventory.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by VD on 2/28/2016.
 */
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
