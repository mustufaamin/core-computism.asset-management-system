package com.core.computism.assasa.ar.service.impl;

import com.core.computism.assasa.ar.builder.ArQuotationBuilder;
import com.core.computism.assasa.ar.dto.ArQuotationDto;
import com.core.computism.assasa.ar.dto.ArQuotationItemDto;
import com.core.computism.assasa.ar.service.ArQuotationService;
import com.core.computism.assasa.common.service.CurrencyService;
import com.core.computism.assasa.exception.AssasaBusinessException;
import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.persistence.entity.ar.ArQuotation;
import com.core.computism.assasa.persistence.entity.ar.ArQuotationItem;
import com.core.computism.assasa.persistence.entity.cmn.Customer;
import com.core.computism.assasa.persistence.entity.pos.PosOrder;
import com.core.computism.assasa.persistence.entity.pos.PosOrderItem;
import com.core.computism.assasa.persistence.repository.ar.ArItemRepository;
import com.core.computism.assasa.persistence.repository.ar.ArQuotationRepository;
import com.core.computism.assasa.pos.domain.PosOrderDto;
import com.core.computism.assasa.pos.domain.PosOrderItemDto;
import com.core.computism.assasa.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VD on 5/28/2016.
 */
@Service(value = "arQuotationService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = PosBusinessException.class)
public class ArQuotationServiceImpl implements ArQuotationService {

    @Autowired private ArQuotationRepository arQuotationRepository;
    @Autowired private ArQuotationBuilder arQuotationBuilder;
    @Autowired private CustomerService customerService;
    @Autowired private CurrencyService currencyService;
    @Autowired private ArItemRepository arItemRepository;

    @Override
    public void save(ArQuotationDto arQuotationDto) throws AssasaBusinessException, PosBusinessException {
        try{
            ArQuotation arQuotation = new ArQuotation();

            arQuotation = arQuotationBuilder.buildArQuotationEntity(arQuotation,arQuotationDto);

            //TODO: Need to create the mechanism to generate Quote Number
            arQuotation.setQuoteNumber("abc/123122/ED");

            arQuotation.setCustomer(customerService.getCustomer(arQuotationDto.getCustomerId()));
            arQuotation.setCurrency(currencyService.getCurrency(arQuotationDto.getCurrencyId()));
            List<ArQuotationItem> quotationItem = createQuotationItem(arQuotationDto.getItems(),arQuotation);
            arQuotation.setArQuotationItems(quotationItem);

            arQuotation = arQuotationRepository.save(arQuotation);

        } catch (PersistenceException | BuilderException e) {
            throw new AssasaBusinessException("Error Occurred While saving the Pos Order ",e);
        }
    }
    private List<ArQuotationItem> createQuotationItem(List<ArQuotationItemDto> arQuotationItemDtos, ArQuotation arQuotation) throws PosBusinessException {
        List<ArQuotationItem> arQuotationItems = new ArrayList<>(arQuotationItemDtos.size());

        for (ArQuotationItemDto arQuotationItemDto : arQuotationItemDtos){
            ArQuotationItem arQuotationItem = new ArQuotationItem();

            arQuotationItem.setArItem(arItemRepository.findOne(arQuotationItemDto.getItemId()));
            arQuotationItem.setArQuotation(arQuotation);
            arQuotationItem.setQuantity(arQuotationItemDto.getQuantity());

            arQuotationItems.add(arQuotationItem);
        }
        return arQuotationItems;
    }
}
