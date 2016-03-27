package com.core.computism.assasa.persistence.repository.pos;

import com.core.computism.assasa.persistence.entity.pos.PosItemGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by M.Mustafa Amin Shah on 3/26/2016.
 */
public interface PosItemGroupRepository  extends JpaRepository<PosItemGroup,Long> {
    @Query("from PosItemGroup pig where pig.billCode.id = :billCodeId")
    List<PosItemGroup> findByBillCodeId(@Param("billCodeId") Long billCodeId);
}
