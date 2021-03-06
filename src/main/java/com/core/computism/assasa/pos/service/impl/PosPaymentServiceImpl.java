package com.core.computism.assasa.pos.service.impl;

import com.core.computism.assasa.exception.ArBusinessException;
import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.persistence.entity.pos.PosPayment;
import com.core.computism.assasa.persistence.repository.pos.PosPaymentRepository;
import com.core.computism.assasa.pos.builder.PosPaymentBuilder;
import com.core.computism.assasa.pos.domain.PosPaymentDto;
import com.core.computism.assasa.pos.service.PosPaymentService;
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

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = PosBusinessException.class)
    public PosPaymentDto add(PosPaymentDto posPaymentDto) throws PosBusinessException {
        try {
            PosPayment posPayment = new PosPayment();

            posPayment = posPaymentBuilder.buildPosPaymentEntity(posPayment,posPaymentDto);
            posPaymentRepository.save(posPayment);

            return posPaymentBuilder.buildPosPaymentDto(posPayment);

        } catch(PersistenceException | BuilderException e){
            throw new PosBusinessException("Error Occurred while adding Payment");
        }
    }

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
