package com.core.computism.assetmanagementsystem.scheduling;

import com.core.computism.assetmanagementsystem.service.TicketResolverService;
import org.quartz.DisallowConcurrentExecution;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Scheduled Job to Auto Resolve the tickets.
 * Created by Venturedive on 8/13/2015.
 */
@DisallowConcurrentExecution
public class AutoResolverJob extends BaseSchedulerJob {
    private static final String JOB_NAME = "Ticket - AutoResolver";

    @Autowired
    private TicketResolverService ticketResolverService;

    @Override
    protected String getJobName() {
        return JOB_NAME;
    }

    @Override
    protected void executeJob() {
        ticketResolverService.autoResolveTickets();
    }
}
