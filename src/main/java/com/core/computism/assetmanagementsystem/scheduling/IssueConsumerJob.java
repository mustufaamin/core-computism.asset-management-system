package com.core.computism.assetmanagementsystem.scheduling;

import com.core.computism.assetmanagementsystem.domain.IssueDTO;
import com.core.computism.assetmanagementsystem.gateway.AmazonSQSGateway;
import com.core.computism.assetmanagementsystem.service.TrackerService;
import org.quartz.DisallowConcurrentExecution;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Scheduled Job to Consume list of Issues from Amazon SQS Queue.
 * Created by Venturedive on 8/13/2015.
 */
@DisallowConcurrentExecution
public class IssueConsumerJob extends BaseSchedulerJob {
    private static final String JOB_NAME = "IssueConsumer";

    @Autowired
    private AmazonSQSGateway amazonSQSGateway;

    @Autowired
    private TrackerService trackerService;

    @Override
    protected String getJobName() {
        return JOB_NAME;
    }

    @Override
    protected void executeJob() {
        List<IssueDTO> issues = amazonSQSGateway.dequeue();
        if (issues.size() > 0) {
            trackerService.inspect(issues);
        }
    }
}
