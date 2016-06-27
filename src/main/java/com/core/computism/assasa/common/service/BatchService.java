package com.core.computism.assasa.common.service;

import com.core.computism.assasa.common.domain.BatchDto;
import com.core.computism.assasa.common.domain.CityDto;
import com.core.computism.assasa.exception.PosBusinessException;

import java.util.List;

/**
 * Created by Mustafa Amin on 3/13/2016.
 */
public interface BatchService {
    Long add(BatchDto batchDto) throws PosBusinessException;

    BatchDto getBatch(Long id);

    List<BatchDto> getAllBatches();

    List<BatchDto> getBatchesByStatus(Integer batchStatus);

    List<BatchDto> getBatchesByType(Integer batchType);
}
