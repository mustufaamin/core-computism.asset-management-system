package com.core.computism.assasa.common.service.impl;

import com.core.computism.assasa.ar.dto.BillCodeDto;
import com.core.computism.assasa.common.builder.BatchBuilder;
import com.core.computism.assasa.common.domain.BatchDto;
import com.core.computism.assasa.common.service.BatchService;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.persistence.entity.ar.billing.BillCode;
import com.core.computism.assasa.persistence.entity.common.Batch;
import com.core.computism.assasa.persistence.repository.common.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
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
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
    public BatchDto add(BatchDto batchDto) throws ArBusinessException {
        try {
            Batch batch = new Batch();
            batch = batchBuilder.buildBatchEntity(batchDto, batch);
            batch = batchRepository.save(batch);

            return batchBuilder.buildBatchDto(batch);
        } catch (BuilderException e) {
            throw new ArBusinessException("Error Occurred While saving batch", e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = ArBusinessException.class)
    public BatchDto update(BatchDto batchDto) throws ArBusinessException {
        try {
            Batch batch = batchRepository.getOne(batchDto.getBatchId());
            batch = batchBuilder.buildBatchEntity(batchDto, batch);

            batch = batchRepository.save(batch);
            return batchBuilder.buildBatchDto(batch);

        } catch (PersistenceException | BuilderException e) {
            throw new ArBusinessException("Error Occurred In BillCode service Update", e);
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

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<BatchDto> search(String searchKey) throws ArBusinessException {
        try {
            searchKey = "%" + searchKey + "%";
            List<Batch> batches = batchRepository.searchBatches(searchKey);
            return batchBuilder.buildBatchDtoList(batches);

        } catch (PersistenceException e) {
            throw new ArBusinessException("Error occurred In Batch service search", e);
        }
    }
}
