package com.core.computism.assasa.service;

import com.core.computism.assasa.domain.CustomerDto;
import com.core.computism.assasa.exception.PosBusinessException;

/**
 * Created by VD on 2/28/2016.
 */
public interface CustomerService {
    Long add(CustomerDto customerDto) throws PosBusinessException;
}
