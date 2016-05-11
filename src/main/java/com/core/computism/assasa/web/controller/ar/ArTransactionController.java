package com.core.computism.assasa.web.controller.ar;

import com.core.computism.assasa.ar.dto.ArTransactionSearchResponseDto;
import com.core.computism.assasa.ar.service.TransactionService;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.util.ServerResponse;
import com.core.computism.assasa.web.controller.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by VD on 5/9/2016.
 */
@Controller(value = "ArTransactionController")
@RequestMapping(value = "/ar/transactions/", produces = {MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8"})
public class ArTransactionController extends BaseController {

    private static final Logger LOGGER = Logger.getLogger(ArTransactionController.class);

    @Autowired
    TransactionService transactionService;

    @RequestMapping(value = "listAllTransactions", method = RequestMethod.GET)
    public @ResponseBody ServerResponse<List<ArTransactionSearchResponseDto>> getArTransactions() throws ArBusinessException {
        LOGGER.info("Ar transaction List..");
        ServerResponse<List<ArTransactionSearchResponseDto>> response = toResponse(transactionService.getArTransactions());
        return response;
    }
}

