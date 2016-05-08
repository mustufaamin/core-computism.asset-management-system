package com.core.computism.assasa.pos.service.impl;

import com.core.computism.assasa.common.service.CurrencyService;
import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.exception.AssasaBusinessException;
import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.persistence.entity.pos.PosOrder;
import com.core.computism.assasa.persistence.entity.pos.PosOrderItem;
import com.core.computism.assasa.persistence.entity.pos.PosPayment;
import com.core.computism.assasa.persistence.repository.pos.PosOrderRepository;
import com.core.computism.assasa.pos.builder.PosOrderBuilder;
import com.core.computism.assasa.pos.builder.PosPaymentBuilder;
import com.core.computism.assasa.pos.domain.PosOrderDto;
import com.core.computism.assasa.pos.domain.PosOrderItemDto;
import com.core.computism.assasa.pos.domain.PosPaymentDto;
import com.core.computism.assasa.pos.service.CustomerService;
import com.core.computism.assasa.pos.service.PosItemService;
import com.core.computism.assasa.pos.service.PosOrderService;
import com.core.computism.assasa.pos.service.PosPaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by M.Mustafa Amin Shah on 4/13/2016.
 */
@Service(value = "posOrderService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = PosBusinessException.class)
public class PosOrderServiceImpl implements PosOrderService {

    @Autowired private PosOrderRepository posOrderRepository;
    @Autowired private PosItemService posItemService;
    @Autowired private PosOrderBuilder posOrderBuilder;
    @Autowired private CustomerService customerService;
    @Autowired private CurrencyService currencyService;

    @Override
    @Transactional(readOnly = true)
    public PosOrder getPosOrder(Long posOrderId) throws PosBusinessException {
        PosOrder posOrder = posOrderRepository.findOne(posOrderId);

        if(posOrder == null){
            throw new PosBusinessException("Unable to find the Pos Order with ID:"+posOrderId);
        }
        return posOrder;

    }

    @Override
    public PosOrderDto save(PosOrderDto posOrderDto) throws PosBusinessException, AssasaBusinessException {
        try{
            PosOrder posOrder = new PosOrder();

            posOrder = posOrderBuilder.buildPosOrderEntity(posOrder,posOrderDto);

            //TODO: Redefine the methodology to generate the Batch and invoice number
            posOrder.setBatchNumber(findCurrentBatchNumber());

            posOrder.setCustomer(customerService.getCustomer(posOrderDto.getCustomerId()));
            posOrder.setCurrency(currencyService.getCurrency(posOrderDto.getCurrencyId()));
            List<PosOrderItem> posOrderItems = createPosOrderItemsForOrder(posOrderDto.getItems(),posOrder);
            posOrder.setPosOrderItems(posOrderItems);

            posOrder = posOrderRepository.save(posOrder);

            return posOrderBuilder.buildPosOrderDto(posOrder);

        } catch (PersistenceException | BuilderException e) {
            throw new PosBusinessException("Error Occurred While saving the Pos Order ",e);
        }
    }
    private List<PosOrderItem> createPosOrderItemsForOrder(List<PosOrderItemDto> posOrderItemDtos,PosOrder posOrder) throws PosBusinessException {
        List<PosOrderItem> posOrderItems = new ArrayList<>(posOrderItemDtos.size());

        for (PosOrderItemDto posOrderItemDto : posOrderItemDtos){
            PosOrderItem posOrderItem = new PosOrderItem();

            posOrderItem.setPosItem(posItemService.findPosItemById(posOrderItemDto.getItemId()));
            posOrderItem.setPosOrder(posOrder);
            posOrderItem.setQuantity(posOrderItemDto.getQuantity());

            posOrderItems.add(posOrderItem);
        }
        return posOrderItems;
    }
    @Transactional(readOnly = true)
    private Long findCurrentInvoiceNumber() throws PosBusinessException {
        try{
            return posOrderRepository.findCurrentInvoiceNumber();
        } catch (PersistenceException e){
            throw new PosBusinessException("Error Occurred while finding Invoie Number",e);
        }
    }
    @Transactional(readOnly = true)
    private Long findCurrentBatchNumber() throws PosBusinessException {
        try{
            return posOrderRepository.findCurrentBatchNumber();
        } catch (PersistenceException e){
            throw new PosBusinessException("Error Occurred while finding Invoie Number",e);
        }
    }


}
