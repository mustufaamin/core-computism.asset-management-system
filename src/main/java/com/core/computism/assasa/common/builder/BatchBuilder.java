package com.core.computism.assasa.common.builder;

import com.core.computism.assasa.common.domain.BatchDto;
import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.persistence.entity.common.Batch;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mustafa Amin Shah on 3/13/2016.
 */
@Component(value = "batchBuilder")
public class BatchBuilder {

    public Batch buildBatchEntity(BatchDto batchDto, Batch batch) throws BuilderException {

        if (batchDto == null) {
            throw new BuilderException("Batch Dto not present");
        }

        batch.setId(batchDto.getBatchId());
        batch.setBatchType(batchDto.getBatchType());
        batch.setBatchStatus(batchDto.getBatchStatus());
        batch.setBatchName(batchDto.getBatchName());
        batch.setBatchCountMethod(batchDto.getBatchCountMethod());
        batch.setBatchAmount(batchDto.getBatchAmount());
        batch.setModuleId(batchDto.getModuleId());
        batch.setDateOpened(batchDto.getDateOpened());
        batch.setOpenedBy(batchDto.getOpenedBy());
        batch.setClosingDate(batchDto.getClosingDate());
        batch.setClosedBy(batchDto.getClosedBy());
        batch.setCloseOnPosting(batchDto.getCloseOnPosting());

        return batch;
    }

    public BatchDto buildBatchDto(Batch batch) {
        BatchDto batchDto = new BatchDto();

        batchDto.setBatchId(batch.getId());
        batchDto.setBatchType(batch.getBatchType());
        batchDto.setBatchStatus(batch.getBatchStatus());
        batchDto.setBatchName(batch.getBatchName());
        batchDto.setBatchCountMethod(batch.getBatchCountMethod());
        batchDto.setBatchAmount(batch.getBatchAmount());
        batchDto.setModuleId(batch.getModuleId());
        batchDto.setDateOpened(batch.getDateOpened());
        batchDto.setOpenedBy(batch.getOpenedBy());
        batchDto.setClosingDate(batch.getClosingDate());
        batchDto.setClosedBy(batch.getClosedBy());
        batchDto.setCloseOnPosting(batch.getCloseOnPosting());

        return batchDto;
    }

    public List<BatchDto> buildBatchDtoList(List<Batch> batches) {
        List<BatchDto> batchDtos = new ArrayList<>(0);

        for (Batch batch : batches) {
            batchDtos.add(buildBatchDto(batch));
        }
        return batchDtos;
    }
}
