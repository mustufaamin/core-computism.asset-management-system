package com.core.computism.assasa.web.controller.ar;

import com.core.computism.assasa.ar.dto.PaymentDto;
import com.core.computism.assasa.ar.service.PaymentService;
import com.core.computism.assasa.exception.ArBusinessException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by VD on 3/6/2016.
 */
@Controller(value = "paymentController")
@RequestMapping(value = "/payments/", produces = {MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8"})
public class PaymentController {

    private static final Logger LOGGER = Logger.getLogger(PaymentController.class);

    @Autowired
    PaymentService paymentService;

    @RequestMapping(value = "addPayment", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addPayment(@RequestBody PaymentDto paymentDto) throws Exception {
        try {
            paymentService.savePayment(paymentDto);
        } catch (ArBusinessException e) {
            LOGGER.error(e);
        }
    }
}
