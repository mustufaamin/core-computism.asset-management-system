package com.core.computism.assasa.service.impl;

import com.core.computism.assasa.persistence.entity.ticket.ProblemType;
import com.core.computism.assasa.persistence.repository.ticket.ProblemTypeRepository;
import com.core.computism.assasa.service.ProblemTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Venturedive on 8/18/2015.
 */
@Service(value = "problemTypeService")
public class ProblemTypeServiceImpl extends BaseService implements ProblemTypeService {

    @Autowired private ProblemTypeRepository repository;

    private static HashMap<String, ProblemType> cachedProblemTypes = new HashMap<>(0);
    private static List<String> nonCriticalProblemTypes = Arrays.asList("CHECK_45_MINS", "CHECK_FLIGHT_STATUS", "CAPTAIN_NEEDS_HELP", "LOCATION_NOT_GEOCODABLE");

    public ProblemType getProblemTypeById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public ProblemType getProblemTypeByCode(String problemTypeCode) {
        ProblemType problemType = cachedProblemTypes.get(problemTypeCode);
        if (problemType == null) {
            logger.debug("Querying Problem Type for code [" + problemTypeCode + "]");
            problemType = repository.findByTypeCode(problemTypeCode);
            cachedProblemTypes.put(problemType.getTypeCode(), problemType);
        }
        return problemType;
    }

    @Override
    public boolean isCriticalProblemType(ProblemType problemType) {
        return !nonCriticalProblemTypes.contains(problemType.getTypeCode());
    }
}
