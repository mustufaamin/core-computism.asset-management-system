package com.core.computism.assetmanagementsystem.service;

import com.core.computism.assetmanagementsystem.persistence.entity.ticket.TicketConfig;

/**
 * Created by Venturedive on 8/24/2015.
 */
public interface TicketConfigService {

    TicketConfig findByProblemTypeAndRobot(Long problemTypeId, String robotName);
}
