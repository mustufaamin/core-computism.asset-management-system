package com.core.computism.assasa.pos.service.impl;

import com.core.computism.assasa.persistence.entity.pos.PosOrder;
import com.core.computism.assasa.pos.domain.PosOrderDto;
import com.core.computism.assasa.pos.service.OrderProcessingService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by M.Mustufa Amin Shah on 4/10/2016.
 */
public class PosSaleOrderProcessingServiceImpl implements OrderProcessingService {
    @Autowired

    @Override
    public boolean processOrder(PosOrderDto posOrderDto) {


        
    }
    private PosOrder saveOrderEntry(PosOrderDto posOrderDto){

    }


}
