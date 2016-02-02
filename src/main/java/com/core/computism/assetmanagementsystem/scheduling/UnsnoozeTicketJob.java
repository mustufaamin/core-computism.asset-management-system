package com.core.computism.assetmanagementsystem.scheduling;

import com.core.computism.assetmanagementsystem.exception.BrainBusinessException;
import com.core.computism.assetmanagementsystem.service.TicketService;
import org.quartz.DisallowConcurrentExecution;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Venture Dive on 9/30/2015.
 */

@DisallowConcurrentExecution
public class UnsnoozeTicketJob extends BaseSchedulerJob {
    private static final String JOB_NAME = "Ticket - Unsnooze";

    @Autowired
    private TicketService ticketService;

    @Override
    protected String getJobName() {
        return JOB_NAME;
    }

    @Override
    protected void executeJob() {
        try {
            ticketService.unsnoozedTickets();
        } catch (BrainBusinessException e) {
            //TODO: It should be handled in Service layer
            logger.error(e.getStackTrace());
        }
    }
}
