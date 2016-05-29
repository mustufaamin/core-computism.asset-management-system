package com.core.computism.assasa.persistence.repository.customer;

import com.core.computism.assasa.persistence.entity.customer.Customer;
import com.core.computism.assasa.persistence.entity.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VD on 5/23/2016.
 */
public interface CustomerTypeRepository extends JpaRepository<CustomerType, Long> {
    @Query("from CustomerType c where c.name like :searchKey")
    List<CustomerType> searchCustomerTypes(@Param("searchKey") String searchKey);
}
