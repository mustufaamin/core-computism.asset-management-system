package com.core.computism.assetmanagementsystem.scheduling;

import com.core.computism.assetmanagementsystem.service.TicketClosureService;
import org.quartz.DisallowConcurrentExecution;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Venture Dive on 11/24/2015.
 */
@DisallowConcurrentExecution
public class ClosureJob extends BaseSchedulerJob {
    private static final String JOB_NAME = "Ticket - Closure";

    @Autowired
    private TicketClosureService ticketClosureService;

    @Override
    protected String getJobName() {
        return JOB_NAME;
    }

    @Override
    protected void executeJob() {
        ticketClosureService.closeTicket();
    }
}
