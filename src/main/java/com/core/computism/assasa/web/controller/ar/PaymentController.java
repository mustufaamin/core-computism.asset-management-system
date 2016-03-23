package com.core.computism.assasa.web.controller.ar;

import com.core.computism.assasa.ar.dto.ArAccountTypeDto;
import com.core.computism.assasa.ar.dto.PaymentDto;
import com.core.computism.assasa.ar.dto.PaymentTypeDto;
import com.core.computism.assasa.ar.service.PaymentService;
import com.core.computism.assasa.ar.service.PaymentTypeService;
import com.core.computism.assasa.exception.ArBusinessException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * Created by VD on 3/6/2016.
 */
@Controller(value = "paymentController")
@RequestMapping(value = "/payments/", produces = {MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8"})
public class PaymentController {

    private static final Logger LOGGER = Logger.getLogger(PaymentController.class);

    @Autowired
    PaymentService paymentService;

    @Autowired
    PaymentTypeService paymentTypeService;

    @RequestMapping(value = "addPayment", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addPayment(@RequestBody PaymentDto paymentDto) throws Exception {
        try {
            paymentService.savePayment(paymentDto);
        } catch (ArBusinessException e) {
            LOGGER.error(e);
        }
    }

    @RequestMapping(value = "saveNPostPayment", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void saveNPostPayment(@RequestBody PaymentDto paymentDto) throws Exception {
        try {
            paymentService.saveNPostPayment(paymentDto);
        } catch (ArBusinessException e) {
            LOGGER.error(e);
        }
    }

    @RequestMapping(value = "addPaymentType", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addPaymentType(@RequestBody PaymentTypeDto paymentTypeDto) throws Exception {
        try {
            paymentTypeService.savePaymentType(paymentTypeDto);
        } catch (ArBusinessException e) {
            LOGGER.error(e);
        }
    }

    @RequestMapping(value = "paymenttypes", method = RequestMethod.GET)
    public @ResponseBody
    List<PaymentTypeDto> getPaymentTypes() throws ArBusinessException {
        List<PaymentTypeDto> paymentTypeDtos = null;
        try {
            paymentTypeDtos = paymentTypeService.getPaymentTypes();
        } catch (ArBusinessException e) {
            LOGGER.error(e);
        }
        return paymentTypeDtos;
    }
}
