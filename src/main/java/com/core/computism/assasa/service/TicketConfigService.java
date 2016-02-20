package com.core.computism.assasa.service;

import com.core.computism.assasa.persistence.entity.ticket.TicketConfig;

/**
 * Created by Venturedive on 8/24/2015.
 */
public interface TicketConfigService {

    TicketConfig findByProblemTypeAndRobot(Long problemTypeId, String robotName);
}
