package com.core.computism.assasa.persistence.repository.ar;

import com.core.computism.assasa.persistence.entity.ar.billing.BillCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by M.Mustufa Amin Shah on 3/23/2016.
 */
public interface BillCodeRepository extends JpaRepository<BillCode,Long> {
    @Query("from BillCode b where b.name like :searchKey")
    List<BillCode> searchBillCodes(@Param("searchKey") String searchKey);

}
