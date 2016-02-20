package com.core.computism.assasa.service.impl;

import com.core.computism.assasa.persistence.entity.ticket.TicketConfig;
import com.core.computism.assasa.persistence.repository.ticket.TicketConfigRepository;
import com.core.computism.assasa.service.TicketConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Venturedive on 8/24/2015.
 */
@Service(value = "ticketConfigService")
public class TicketConfigServiceImpl extends BaseService implements TicketConfigService {

    private static final String DEFAULT_ROBOT = "any robot";

    @Autowired private TicketConfigRepository repository;

    private static HashMap<String, TicketConfig> cachedTicketConfigs = new HashMap<>(0);

    @Override
    public TicketConfig findByProblemTypeAndRobot(Long problemTypeId, String robotName) {
        logger.debug("Finding Ticket Config for problem type Id [" + problemTypeId + "], robot [" + robotName + "]");

        TicketConfig result = getCachedTicketConfig(problemTypeId, robotName);

        if (result == null) {
            List<String> robots = Arrays.asList(DEFAULT_ROBOT, robotName);
            List<TicketConfig> ticketConfigs = repository.findByProblemTypeAndRobot(problemTypeId, robots);
            for (TicketConfig config : ticketConfigs) {
                String key = getKey(problemTypeId, config.getRobotName());
                cachedTicketConfigs.put(key, config);
            }
            result = getCachedTicketConfig(problemTypeId, robotName);
        }
        return result;
    }

    private TicketConfig getCachedTicketConfig(Long problemTypeId, String robotName) {
        String key = getKey(problemTypeId, robotName);
        TicketConfig ticketConfig = cachedTicketConfigs.get(key);

        if (ticketConfig == null) {
            key = getKey(problemTypeId, DEFAULT_ROBOT);
            ticketConfig = cachedTicketConfigs.get(key);
        }
        return ticketConfig;
    }

    private String getKey(Long problemTypeId, String robotName) {
        return problemTypeId + "_" + robotName;
    }
}
