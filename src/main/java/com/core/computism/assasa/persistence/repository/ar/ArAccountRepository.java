package com.core.computism.assasa.persistence.repository.ar;

import com.core.computism.assasa.persistence.entity.ar.account.ArAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VD on 2/18/2016.
 */
public interface ArAccountRepository extends JpaRepository<ArAccount, Long> {
    @Query("from ArAccount acc where acc.accountStatus = 1 and acc.customer.firstName like '%' || :searchKey || '%'  or acc.customer.lastName like '%' || :searchKey || '%' ")
    List<ArAccount> getArAccountBySearchKey(@Param("searchKey") String searchKey);
}
