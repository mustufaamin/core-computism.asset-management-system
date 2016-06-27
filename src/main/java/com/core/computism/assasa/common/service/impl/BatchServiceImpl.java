package com.core.computism.assasa.common.service.impl;

import com.core.computism.assasa.common.builder.BatchBuilder;
import com.core.computism.assasa.common.builder.CityBuilder;
import com.core.computism.assasa.common.domain.BatchDto;
import com.core.computism.assasa.common.domain.CityDto;
import com.core.computism.assasa.common.service.BatchService;
import com.core.computism.assasa.common.service.CityService;
import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.persistence.entity.common.Batch;
import com.core.computism.assasa.persistence.entity.common.City;
import com.core.computism.assasa.persistence.repository.common.BatchRepository;
import com.core.computism.assasa.persistence.repository.common.CityRepository;
import com.core.computism.assasa.persistence.repository.common.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by M.Mustafa Amin Shah on 3/13/2016.
 */
@Service(value = "batchService")
public class BatchServiceImpl implements BatchService {

    @Autowired
    BatchRepository batchRepository;
    @Autowired
    BatchBuilder batchBuilder;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = PosBusinessException.class)
    public Long add(BatchDto batchDto) throws PosBusinessException {
        try {
            Batch batch = batchBuilder.buildBatchEntity(batchDto);
            batch = batchRepository.save(batch);

            return batch.getId();
        } catch (BuilderException e) {
            throw new PosBusinessException("Error Occurred While saving batch", e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public BatchDto getBatch(Long id) {
        return batchBuilder.buildBatchDto(batchRepository.findOne(id));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<BatchDto> getAllBatches() {
        List<Batch> batches = batchRepository.findAll();
        return batchBuilder.buildBatchDtoList(batches);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<BatchDto> getBatchesByStatus(Integer batchStatus) {
        List<Batch> batches = batchRepository.findBatchesByStatus(batchStatus);
        return batchBuilder.buildBatchDtoList(batches);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<BatchDto> getBatchesByType(Integer batchType) {
        List<Batch> batches = batchRepository.findBatchesByType(batchType);
        return batchBuilder.buildBatchDtoList(batches);
    }
}
