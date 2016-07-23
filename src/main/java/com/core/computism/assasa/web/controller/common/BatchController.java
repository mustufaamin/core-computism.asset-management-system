package com.core.computism.assasa.web.controller.common;

import com.core.computism.assasa.ar.dto.BillCodeDto;
import com.core.computism.assasa.common.domain.BatchDto;
import com.core.computism.assasa.common.service.BatchService;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.util.ServerResponse;
import com.core.computism.assasa.web.controller.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Faizan Iftikhar on 06/13/2016.
 */
@RestController
@RequestMapping(value = "batch/")
public class BatchController extends BaseController {
    private static final Logger LOGGER = Logger.getLogger(BatchController.class);

    @Autowired
    BatchService batchService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ServerResponse<BatchDto> add(@RequestBody BatchDto batchDto) throws ArBusinessException {
        LOGGER.info("Adding batchDto..");
        ServerResponse<BatchDto> response = toResponse(batchService.add(batchDto));
        return response;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ServerResponse<BatchDto> update(@RequestBody BatchDto batchDto) throws ArBusinessException {
        LOGGER.info("update BillCode..");
        ServerResponse<BatchDto> response = toResponse(batchService.update(batchDto));
        return response;
    }

    @RequestMapping(value = "get/{batchId}", method = RequestMethod.GET)
    public ServerResponse<BatchDto> get(@PathVariable Long batchId) throws ArBusinessException {
        LOGGER.info("Retrieving batches...");
        ServerResponse<BatchDto> response = toResponse(batchService.getBatch(batchId));
        return response;
    }

    @RequestMapping(value = "list/type/{batchType}", method = RequestMethod.GET)
    public ServerResponse<List<BatchDto>> getBatchesByType(@PathVariable Integer batchType) throws ArBusinessException {
        LOGGER.info("Retrieving batches ...");
        ServerResponse<List<BatchDto>> response = toResponse(batchService.getBatchesByType(batchType));
        return response;
    }

    @RequestMapping(value = "list/status/{batchStatus}", method = RequestMethod.GET)
    public ServerResponse<List<BatchDto>> getBatchesByStatus(@PathVariable Integer batchStatus) throws ArBusinessException {
        LOGGER.info("Retrieving batches ...");
        ServerResponse<List<BatchDto>> response = toResponse(batchService.getBatchesByStatus(batchStatus));
        return response;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ServerResponse<List<BatchDto>> getAllBatches() throws PosBusinessException {
        LOGGER.info("Retrieving batches ...");
        ServerResponse<List<BatchDto>> response = toResponse(batchService.getAllBatches());
        return response;
    }

    @RequestMapping(value = "search/{searchKey}", method = RequestMethod.GET)
    public ServerResponse<List<BatchDto>> search(@PathVariable String searchKey) throws ArBusinessException {
        LOGGER.info("search Batch..");
        ServerResponse<List<BatchDto>> response = toResponse(batchService.search(searchKey));
        return response;
    }

}
