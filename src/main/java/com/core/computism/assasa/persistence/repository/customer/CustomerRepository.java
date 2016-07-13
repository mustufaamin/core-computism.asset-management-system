package com.core.computism.assasa.persistence.repository.customer;

import com.core.computism.assasa.persistence.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VD on 2/28/2016.
 */
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query("from Customer c where c.firstName like :searchKey")
    List<Customer> searchCustomers(@Param("searchKey") String searchKey);
}