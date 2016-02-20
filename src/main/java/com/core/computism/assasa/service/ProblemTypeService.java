package com.core.computism.assasa.service;

import com.core.computism.assasa.persistence.entity.ticket.ProblemType;

/**
 * Created by Venturedive on 8/18/2015.
 */
public interface ProblemTypeService {

    ProblemType getProblemTypeById(Long id);
    ProblemType getProblemTypeByCode(String problemTypeCode);
    boolean isCriticalProblemType(ProblemType problemType);
}
