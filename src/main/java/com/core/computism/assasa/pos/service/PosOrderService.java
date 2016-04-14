package com.core.computism.assasa.pos.service;

import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.persistence.entity.pos.PosOrder;
import com.core.computism.assasa.pos.domain.PosOrderDto;

/**
 * Created by VD on 4/13/2016.
 */
public interface PosOrderService {

    PosOrder save(PosOrderDto posOrderDto) throws PosBusinessException;
}
