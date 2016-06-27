package com.core.computism.assasa.persistence.repository.common;

import com.core.computism.assasa.persistence.entity.common.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VD on 6/28/2016.
 */
public interface BatchRepository extends JpaRepository<Batch, Long> {

    @Query("from Batch b where b.batchStatus= :batchStatus")
    List<Batch> findBatchesByStatus(@Param("batchStatus") Integer batchStatus);

    @Query("from Batch b where b.batchType= :batchType")
    List<Batch> findBatchesByType(@Param("batchType") Integer batchType);
}
