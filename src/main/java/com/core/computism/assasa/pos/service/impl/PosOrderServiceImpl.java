package com.core.computism.assasa.pos.service.impl;

import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.persistence.entity.pos.PosItem;
import com.core.computism.assasa.persistence.entity.pos.PosOrder;
import com.core.computism.assasa.persistence.entity.pos.PosOrderItem;
import com.core.computism.assasa.persistence.entity.pos.PosPayment;
import com.core.computism.assasa.persistence.repository.pos.PosOrderRepository;
import com.core.computism.assasa.pos.builder.PosOrderBuilder;
import com.core.computism.assasa.pos.builder.PosPaymentBuilder;
import com.core.computism.assasa.pos.domain.PosOrderDto;
import com.core.computism.assasa.pos.domain.PosOrderItemDto;
import com.core.computism.assasa.pos.domain.PosPaymentDto;
import com.core.computism.assasa.pos.domain.PosPaymentTypeDto;
import com.core.computism.assasa.pos.service.CustomerService;
import com.core.computism.assasa.pos.service.PosItemService;
import com.core.computism.assasa.pos.service.PosOrderService;
import com.core.computism.assasa.pos.service.PosPaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by M.Mustafa Amin Shah on 4/13/2016.
 */
public class PosOrderServiceImpl implements PosOrderService {

    @Autowired private PosOrderRepository posOrderRepository;
    @Autowired private PosPaymentBuilder posPaymentBuilder;
    @Autowired private PosItemService posItemService;
    @Autowired private PosOrderBuilder posOrderBuilder;
    @Autowired private CustomerService customerService;
    @Autowired private PosPaymentTypeService posPaymentTypeService;


    @Override
    public PosOrder save(PosOrderDto posOrderDto) throws PosBusinessException {
        try{
            PosOrder posOrder = new PosOrder();

            posOrder = posOrderBuilder.buildPosOrderEntity(posOrder,posOrderDto);

            posOrder.setCustomer(customerService.getCustomer(posOrderDto.getCustomerId()));
            List<PosOrderItem> posOrderItems = createPosOrderItemsForOrder(posOrderDto.getItems(),posOrder);
            posOrder.setPosOrderItems(posOrderItems);
            posOrder.setPosPayments(createPosPayment(posOrderDto.getPosPaymentDtos(),posOrder));

            return posOrderRepository.save(posOrder);

        } catch (PersistenceException | BuilderException e){
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
    private List<PosPayment> createPosPayment(List<PosPaymentDto> posPaymentDtos,PosOrder posOrder) throws BuilderException, PosBusinessException {

        List<PosPayment> posPayments = new ArrayList<>();
        for(PosPaymentDto posPaymentDto : posPaymentDtos ){
            PosPayment posPayment = new PosPayment();

            posPayment = posPaymentBuilder.buildPosPaymentEntity(posPayment,posPaymentDto);
            posPayment.setPosOrder(posOrder);
            posPayment.setPosPaymentType(posPaymentTypeService.findPaymentType(posPaymentDto.getPosPaymentTypeId()));

            posPayments.add(posPayment);
        }
        return posPayments;
    }
}
