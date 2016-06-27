package com.core.computism.assasa.web.controller.common;

import com.core.computism.assasa.common.domain.BatchDto;
import com.core.computism.assasa.common.domain.CityDto;
import com.core.computism.assasa.common.service.BatchService;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.util.ServerResponse;
import com.core.computism.assasa.web.controller.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by M.Mustufa Amin Shah on 3/13/2016.
 */
@RestController
@RequestMapping(value = "batch/")
public class BatchController extends BaseController {
    private static final Logger LOGGER = Logger.getLogger(BatchController.class);

    @Autowired
    BatchService batchService;

    @RequestMapping(value = "get/{batchId}", method = RequestMethod.GET)
    public ServerResponse<BatchDto> get(@PathVariable Long batchId) throws PosBusinessException {
        LOGGER.info("Retrieving batches...");
        ServerResponse<BatchDto> response = toResponse(batchService.getBatch(batchId));
        return response;
    }
    @RequestMapping(value = "list/type/{batchType}", method = RequestMethod.GET)
    public ServerResponse<List<BatchDto>> getBatchesByType(@PathVariable Integer batchType) throws PosBusinessException {
        LOGGER.info("Retrieving batches ...");
        ServerResponse<List<BatchDto>> response = toResponse(batchService.getBatchesByType(batchType));
        return response;
    }

    @RequestMapping(value = "list/status/{batchStatus}", method = RequestMethod.GET)
    public ServerResponse<List<BatchDto>> getBatchesByStatus(@PathVariable Integer batchStatus) throws PosBusinessException {
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

}
