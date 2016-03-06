package com.core.computism.assasa.config;

import com.core.computism.assasa.scheduling.AutoResolverJob;
import com.core.computism.assasa.scheduling.ClosureJob;
import com.core.computism.assasa.scheduling.IssueConsumerJob;
import org.quartz.SimpleTrigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import java.util.Properties;

/**
 * Created by Venturedive on 8/13/2015.
 */
//@Configuration
public class JobConfig {

    private static final String ISSUE_CONSUMER = "BRAIN_ISSUE_CONSUMER";
    private static final String AUTO_RESOLVER = "BRAIN_AUTO_RESOLVER";
    private static final String CLOSE_TICKET = "BRAIN_CLOSE_TICKET";

//    private static final String UNSNOOZE_TICKETS = "BRAIN_UNSNOOZE_TICKETS";


    @Bean
    public JobDetailFactoryBean closeTicketJobDetail() {
        JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
        jobDetailFactory.setJobClass(ClosureJob.class);
        jobDetailFactory.setName(CLOSE_TICKET + "_JOB");
        jobDetailFactory.setGroup(CLOSE_TICKET);
        jobDetailFactory.setRequestsRecovery(true);
        return jobDetailFactory;
    }

    @Bean
    public SimpleTriggerFactoryBean closeTicketJobTrigger() {
        SimpleTriggerFactoryBean triggerFactory = new SimpleTriggerFactoryBean();
        triggerFactory.setName(CLOSE_TICKET + "_TRIGGER");
        triggerFactory.setGroup(CLOSE_TICKET);
        triggerFactory.setStartDelay(60 * 1000); // 1 minute
        triggerFactory.setRepeatInterval(ApplicationProperties.CLOSE_TICKET_INTERVAL_SEC * 1000); // Convert to MilliSecs.
        triggerFactory.setJobDetail(closeTicketJobDetail().getObject());
        triggerFactory.setMisfireInstruction(SimpleTrigger.MISFIRE_INSTRUCTION_FIRE_NOW);
        return triggerFactory;
    }

    @Bean
    public JobDetailFactoryBean autoResolverJobDetail() {
        JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
        jobDetailFactory.setJobClass(AutoResolverJob.class);
        jobDetailFactory.setName(AUTO_RESOLVER + "_JOB");
        jobDetailFactory.setGroup(AUTO_RESOLVER);
        jobDetailFactory.setRequestsRecovery(true);
        return jobDetailFactory;
    }

    @Bean
    public SimpleTriggerFactoryBean autoResolverJobTrigger() {
        SimpleTriggerFactoryBean triggerFactory = new SimpleTriggerFactoryBean();
        triggerFactory.setName(AUTO_RESOLVER + "_TRIGGER");
        triggerFactory.setGroup(AUTO_RESOLVER);
        triggerFactory.setStartDelay(ApplicationProperties.AUTO_RESOLVER_INTERVAL_SEC * 1000); // Convert to MilliSecs.
        triggerFactory.setRepeatInterval(ApplicationProperties.AUTO_RESOLVER_INTERVAL_SEC * 1000); // Convert to MilliSecs.
        triggerFactory.setJobDetail(autoResolverJobDetail().getObject());
        triggerFactory.setMisfireInstruction(SimpleTrigger.MISFIRE_INSTRUCTION_FIRE_NOW);
        return triggerFactory;
    }

    @Bean
    public JobDetailFactoryBean issueConsumerJobDetail() {
        JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
        jobDetailFactory.setJobClass(IssueConsumerJob.class);
        jobDetailFactory.setName(ISSUE_CONSUMER + "_JOB");
        jobDetailFactory.setGroup(ISSUE_CONSUMER);
        jobDetailFactory.setRequestsRecovery(true);

        return jobDetailFactory;
    }

    @Bean
    public SimpleTriggerFactoryBean issueConsumerJobTrigger() {
        SimpleTriggerFactoryBean triggerFactory = new SimpleTriggerFactoryBean();
        triggerFactory.setName(ISSUE_CONSUMER + "_TRIGGER");
        triggerFactory.setGroup(ISSUE_CONSUMER);
        triggerFactory.setRepeatInterval(ApplicationProperties.ISSUE_CONSUMER_INTERVAL_SEC * 1000); // Convert to MilliSecs.
        triggerFactory.setJobDetail(issueConsumerJobDetail().getObject());
        triggerFactory.setMisfireInstruction(SimpleTrigger.MISFIRE_INSTRUCTION_FIRE_NOW);
        return triggerFactory;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
        scheduler.setSchedulerName("harmonyBrainScheduler");
        scheduler.setOverwriteExistingJobs(true);
        scheduler.setWaitForJobsToCompleteOnShutdown(true);
        scheduler.setAutoStartup(true);

        Properties properties = new Properties();
        properties.put("org.quartz.threadPool.class","org.quartz.simpl.SimpleThreadPool");
        properties.put("org.quartz.threadPool.threadCount","50");
        scheduler.setQuartzProperties(properties);

        scheduler.setTriggers(
            /*issueConsumerJobTrigger().getObject(),
            closeTicketJobTrigger().getObject(),
            autoResolverJobTrigger().getObject()*/
//                unsnoozeTicketJobTrigger().getObject(),// Turned off the nsnooze ticket job feature
        );
        return scheduler;
    }
}
