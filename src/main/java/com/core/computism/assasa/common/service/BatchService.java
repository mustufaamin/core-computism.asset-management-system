package com.core.computism.assasa.common.service;

import com.core.computism.assasa.common.domain.BatchDto;
import com.core.computism.assasa.common.domain.CityDto;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.persistence.entity.common.Batch;

import java.util.List;

/**
 * Created by Mustafa Amin on 3/13/2016.
 */
public interface BatchService {
    BatchDto add(BatchDto batchDto) throws ArBusinessException;

    BatchDto update(BatchDto batchDto) throws ArBusinessException;

    BatchDto getBatch(Long id);

    List<BatchDto> getAllBatches();

    List<BatchDto> getBatchesByStatus(Integer batchStatus);

    List<BatchDto> getBatchesByType(Integer batchType);

    List<BatchDto> search(String searchKey) throws ArBusinessException;
}
