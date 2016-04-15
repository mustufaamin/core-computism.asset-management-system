package com.core.computism.assasa.pos.builder;

import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.persistence.entity.pos.PosPayment;
import com.core.computism.assasa.pos.domain.PosPaymentDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VD on 3/29/2016.
 */
@Component(value = "posPaymentBuilder")
public class PosPaymentBuilder {

    public PosPaymentDto buildPosPaymentDto(PosPayment posPayment) throws BuilderException {
        if(posPayment == null){
            throw new BuilderException("Unable to create PosPayment DTO payment is NULL");
        }

        PosPaymentDto posPaymentDto =new PosPaymentDto();

        posPaymentDto.setId(posPayment.getId());
        posPaymentDto.setAmount(posPayment.getAmount());
        posPaymentDto.setPaymentDate(posPayment.getPaymentDate());
        posPaymentDto.setPosPaymentTypeId(posPayment.getPosPaymentType().getId());
        posPaymentDto.setPosPaymentTypeName(posPayment.getPosPaymentType().getPaymentTypeName());
        posPaymentDto.setTerminalId(posPayment.getTerminalId());
        posPaymentDto.setTransactionId(posPayment.getTransactionId());
        posPaymentDto.setPosOrderId(posPayment.getPosOrder().getId());

        return  posPaymentDto;
    }

    public PosPayment buildPosPaymentEntity(PosPayment posPayment,PosPaymentDto posPaymentDto) throws BuilderException {

        if(posPayment==null || posPaymentDto == null){
            throw new BuilderException("Unable to create PosPayment Entity");
        }

        posPayment.setAmount(posPaymentDto.getAmount());
        posPayment.setPaymentDate(posPaymentDto.getPaymentDate());
        posPayment.setTerminalId(posPaymentDto.getTerminalId());
        posPayment.setTransactionId(posPaymentDto.getTransactionId());

        return posPayment;
    }

    public List<PosPaymentDto> buildPosPaymentDtoList(List<PosPayment> posPayments) throws BuilderException {
        List<PosPaymentDto> posPaymentDtos = new ArrayList<>(posPayments.size());

        for(PosPayment posPayment : posPayments){
            posPaymentDtos.add(buildPosPaymentDto(posPayment));
        }

        return posPaymentDtos;
    }
}
