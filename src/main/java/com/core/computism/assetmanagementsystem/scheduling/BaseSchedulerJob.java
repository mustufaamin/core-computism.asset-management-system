package com.core.computism.assetmanagementsystem.scheduling;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * Created by Venturedive on 12/4/2015.
 */
public abstract class BaseSchedulerJob extends QuartzJobBean {

    protected Logger logger = Logger.getLogger(getClass());

    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Long startTime = System.currentTimeMillis();
        logger.info("Starting Job [" + getJobName() + "]...");

        try {
            SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
            executeJob();

        } catch (Exception ex) {
            logger.error("Error executing job [" + getJobName() + "]", ex);
        }

        Long lapseTime = System.currentTimeMillis() - startTime;
        logger.info("Job [" + getJobName() + "] - Execution Completed in (millis): " + lapseTime);
    }

    protected abstract String getJobName();

    protected abstract void executeJob();
}
