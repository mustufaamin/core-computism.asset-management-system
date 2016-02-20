package com.core.computism.assasa.gateway.impl;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClient;
import com.amazonaws.services.sqs.buffered.AmazonSQSBufferedAsyncClient;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequest;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.core.computism.assasa.config.ApplicationProperties;
import com.core.computism.assasa.domain.IssueDTO;
import com.core.computism.assasa.gateway.AmazonSQSGateway;
import com.core.computism.assasa.util.builder.IssueBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venturedive on 8/10/2015.
 */
@Service(value = "amazonSQSGateway")
public class AmazonSQSGatewayImpl implements AmazonSQSGateway {

    private static final Logger LOGGER = Logger.getLogger(AmazonSQSGatewayImpl.class);

    private static Object singletonLock = new Object();
    private String queueUrl;
    private static AmazonSQSAsync amazonSQSAsyncClient;

    @Autowired
    protected ApplicationProperties applicationProperties;

    protected AmazonSQSAsync getAmazonSQSAsyncClient() {
        if (amazonSQSAsyncClient == null) {
            synchronized (singletonLock) {
                if(amazonSQSAsyncClient == null) {

                    LOGGER.info("Connecting to Amazon SQS Gateway...");
                    amazonSQSAsyncClient = new AmazonSQSBufferedAsyncClient(
                            new AmazonSQSAsyncClient(
                                    new BasicAWSCredentials(ApplicationProperties.SQS_ACCESS_KEY, ApplicationProperties.SQS_SECRET_KEY)
                            )
                    );
                    amazonSQSAsyncClient.setRegion(Region.getRegion(Regions.EU_WEST_1));
                    LOGGER.info("Connected to Amazon SQS Gateway.");
                }
            }
        }
        return amazonSQSAsyncClient;
    }

    @Override
    public List<IssueDTO> dequeue() {

        IssueBuilder issueBuilder = new IssueBuilder();

        LOGGER.info("Consuming issues from queue [" + getQueueName() + "]");

        List<Message> messages = receiveMessagesFromQueue();
        LOGGER.info("Received [" + messages.size() + "] messages from queue [" + getQueueName() + "]");

        if (messages.size() > 0) {
            deleteMessagesFromQueue(messages);
        }

        return issueBuilder.buildIssues(messages);
    }

    private List<Message> receiveMessagesFromQueue() {
        return getAmazonSQSAsyncClient().receiveMessage(
                new ReceiveMessageRequest(getQueueUrl()).withMaxNumberOfMessages(300)
        ).getMessages();
    }

    private void deleteMessagesFromQueue(List<Message> messages) {
        List<DeleteMessageBatchRequestEntry> deleteEntries = new ArrayList<>(messages.size());
        int id = 0;
        for (Message message : messages) {
            deleteEntries.add(new DeleteMessageBatchRequestEntry(String.valueOf(id++), message.getReceiptHandle()));
        }
        getAmazonSQSAsyncClient().deleteMessageBatchAsync(
                new DeleteMessageBatchRequest(getQueueUrl(), deleteEntries)
        );
        LOGGER.info("Deleted [" + messages.size() + "] messages from queue [" + getQueueName() + "]");
    }

    private String getQueueUrl() {
        if (queueUrl == null) {
            queueUrl = getAmazonSQSAsyncClient().getQueueUrl( getQueueName() ).getQueueUrl();
        }
        return queueUrl;
    }

    protected String getQueueName() {
        return applicationProperties.getSqsProblemQueueName();
    }
}
