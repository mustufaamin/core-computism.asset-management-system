package com.core.computism.assasa.service;

import com.core.computism.assasa.domain.SupplierDto;
import com.core.computism.assasa.exception.PosBusinessException;

/**
 * Created by VD on 2/28/2016.
 */
public interface SupplierService {
    Long addSupplier(SupplierDto supplierDto) throws PosBusinessException;
}
