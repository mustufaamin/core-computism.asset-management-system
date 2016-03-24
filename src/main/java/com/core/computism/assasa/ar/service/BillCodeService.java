package com.core.computism.assasa.ar.service;

import com.core.computism.assasa.ar.dto.BillCodeDto;
import com.core.computism.assasa.exception.ArBusinessException;

import java.util.List;

/**
 * Created by M.Mustufa Amin on 3/23/2016.
 */
public interface BillCodeService {
    BillCodeDto add(BillCodeDto billCodeDto) throws ArBusinessException;
    BillCodeDto update(BillCodeDto billCodeDto) throws ArBusinessException;
    List<BillCodeDto> list() throws ArBusinessException;
}
