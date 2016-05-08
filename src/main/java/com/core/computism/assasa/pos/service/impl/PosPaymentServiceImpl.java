package com.core.computism.assasa.pos.service.impl;

import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.persistence.entity.pos.PosOrder;
import com.core.computism.assasa.persistence.entity.pos.PosPayment;
import com.core.computism.assasa.persistence.repository.pos.PosPaymentRepository;
import com.core.computism.assasa.pos.builder.PosPaymentBuilder;
import com.core.computism.assasa.pos.domain.PosPaymentDto;
import com.core.computism.assasa.pos.domain.type.PosOrderStatus;
import com.core.computism.assasa.pos.service.PosItemService;
import com.core.computism.assasa.pos.service.PosOrderService;
import com.core.computism.assasa.pos.service.PosPaymentService;
import com.core.computism.assasa.pos.service.PosPaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by M.Mustufa Amin Shah on 3/29/2016.
 */
@Service(value = "posPaymentService")
public class PosPaymentServiceImpl implements PosPaymentService {

    @Autowired private PosPaymentRepository posPaymentRepository;
    @Autowired private PosPaymentBuilder posPaymentBuilder;
    @Autowired private PosOrderService posOrderService;
    @Autowired private PosItemService posItemService;
    @Autowired private PosPaymentTypeService posPaymentTypeService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = PosBusinessException.class)
    public PosPaymentDto add(PosPaymentDto posPaymentDto) throws PosBusinessException {
        try {
            PosPayment posPayment = new PosPayment();

            posPayment = posPaymentBuilder.buildPosPaymentEntity(posPayment,posPaymentDto);
            PosOrder posOrder = posOrderService.getPosOrder(posPaymentDto.getPosOrderId());

            //TODO: Need to look at it must create the criteria to set the paid
            posOrder.setPosOrderStatus(PosOrderStatus.PAID);

            posPayment.setPosOrder(posOrderService.getPosOrder(posPaymentDto.getPosOrderId()));
            posPayment.setPosPaymentType(posPaymentTypeService.findPaymentType(posPaymentDto.getPosPaymentTypeId()));

            posPayment = posPaymentRepository.save(posPayment);

            posItemService.removeItemStock(posPayment.getPosOrder());

            return posPaymentBuilder.buildPosPaymentDto(posPayment);

        } catch(PersistenceException | BuilderException e){
            throw new PosBusinessException("Error Occurred while adding Payment");
        }
    }

    //TODO : Need to work on it
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = PosBusinessException.class)
     public PosPaymentDto update(PosPaymentDto posPaymentDto) throws PosBusinessException {
        try{
            PosPayment posPayment = posPaymentRepository.findOne(posPaymentDto.getId());

            posPayment = posPaymentBuilder.buildPosPaymentEntity(posPayment,posPaymentDto);
            posPaymentRepository.save(posPayment);

            return posPaymentBuilder.buildPosPaymentDto(posPayment);

        } catch (PersistenceException | BuilderException e){
            throw new PosBusinessException("Error Occurred while Update payment");
        }
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<PosPaymentDto> list() throws PosBusinessException {
        try {
            List<PosPayment> posPayments = posPaymentRepository.findAll();
            return posPaymentBuilder.buildPosPaymentDtoList(posPayments);
        } catch(PersistenceException | BuilderException e){
            throw new PosBusinessException("Error In Listing the Payment");
        }
    }
}
