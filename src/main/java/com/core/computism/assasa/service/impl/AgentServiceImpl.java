package com.core.computism.assasa.service.impl;

import com.core.computism.assasa.persistence.entity.ticket.Agent;
import com.core.computism.assasa.persistence.repository.ticket.AgentRepository;
import com.core.computism.assasa.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Venturedive on 11/26/2015.
 */

@Service(value = "agentService")
public class AgentServiceImpl extends BaseService implements AgentService {

    @Autowired private AgentRepository agentRepository;

    private static Agent harmonySystemAgent;

    @Override
    public Agent getSystemAgent() {
        if (harmonySystemAgent == null) {
            harmonySystemAgent = agentRepository.findByFirstNameAndLastName("HARMONY", "SYSTEM");
            logger.info("Found Harmony System Agent");
        }
        return harmonySystemAgent;
    }
}
