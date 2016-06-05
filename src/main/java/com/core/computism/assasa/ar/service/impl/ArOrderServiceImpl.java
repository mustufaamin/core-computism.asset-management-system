package com.core.computism.assasa.ar.service.impl;

import com.core.computism.assasa.ar.builder.ArOrderBuilder;
import com.core.computism.assasa.ar.service.ArOrderService;
import com.core.computism.assasa.ar.service.ArQuotationService;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.persistence.entity.ar.ArOrder;
import com.core.computism.assasa.persistence.entity.ar.ArQuotation;
import com.core.computism.assasa.persistence.repository.ar.ArOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by VD on 5/28/2016.
 */
@Service(value = "arOrderService")
public class ArOrderServiceImpl implements ArOrderService {

    @Autowired private ArQuotationService arQuotationService;
    @Autowired private ArOrderBuilder arOrderBuilder;
    @Autowired private ArOrderRepository arOrderRepository;

    public Long generateOrder(Long quotationId) throws ArBusinessException {
        try {
            ArQuotation arQuotation = arQuotationService.findQuotationById(quotationId);

            ArOrder arOrder = new ArOrder();
            arOrder = arOrderBuilder.buildArOrderEntity(arQuotation, arOrder);

            arOrder = arOrderRepository.save(arOrder);
            return arOrder.getId();
        } catch (BuilderException e){
            throw new ArBusinessException(e);
        }
    }
}
