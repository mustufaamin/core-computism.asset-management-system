package com.core.computism.assasa.ar.builder;

import com.core.computism.assasa.ar.enumtype.ArOrderStatus;
import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.persistence.entity.ar.ArOrder;
import com.core.computism.assasa.persistence.entity.ar.ArQuotation;
import org.springframework.stereotype.Component;

/**
 * Created by VD on 5/29/2016.
 */
@Component(value = "arOrderBuilder")
public class ArOrderBuilder {
    public ArOrder buildArOrderEntity(ArQuotation arQuotation,ArOrder arOrder) throws BuilderException {
        if(arQuotation == null){
            throw new BuilderException(" Quotation not found");
        }

        arOrder.setArQuotation(arQuotation);
        arOrder.setSubject(arQuotation.getSubject());
        arOrder.setOrderDeliveredDate(null);
        arOrder.setArOrderStatus(ArOrderStatus.NOT_DELIVERED);

        return arOrder;
    }
}
