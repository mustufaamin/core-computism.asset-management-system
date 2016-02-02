package com.core.computism.assetmanagementsystem.util;

import com.amazonaws.services.sqs.model.Message;
import com.core.computism.assetmanagementsystem.BaseUnitTest;
import com.core.computism.assetmanagementsystem.util.builder.IssueBuilder;
import com.core.computism.assetmanagementsystem.domain.IssueDTO;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;

/**
 * Created by Venturedive on 8/10/2015.
 */
public class IssueBuilderTest extends BaseUnitTest {

    @Test
    public void testBuildIssues() {
        List<Message> messages = Arrays.asList(getMessage1(), getMessage2());
        IssueBuilder issueBuilder = new IssueBuilder();

        List<IssueDTO> actual = issueBuilder.buildIssues(messages);
        assertNotNull(actual);
        assertThat(actual, hasSize(messages.size()));

        assertThat(actual.get(0), allOf
                (
                hasProperty("bookingId", equalTo(3097718)),
                hasProperty("robotName", equalTo("Captain Not Assigned - Dubai")),
                hasProperty("problemType", equalTo("CAPTAIN_NOT_ASSIGNED"))
        ));

        assertThat(actual.get(1), allOf(
                hasProperty("bookingId", equalTo(3115171)),
                hasProperty("robotName", equalTo("Now Booking Not Arrived")),
                hasProperty("problemType", equalTo("NOW_BOOKING_NOT_ARRIVED"))
        ));
    }

    private Message getMessage1() {
        Message message = new Message();
        message.setMessageId("9d18320c-37dc-4f29-b185-072d2c96c2a1");
        message.setBody("{\n" +
                "  \"bookingId\" : 3097718,\n" +
                "  \"robotName\" : \"Captain Not Assigned - Dubai\",\n" +
                "  \"problemType\" : \"CAPTAIN_NOT_ASSIGNED\"\n" +
                "}");
        return message;
    }

    private Message getMessage2() {
        Message message = new Message();
        message.setMessageId("194da47f-7469-4711-9427-58e7baaa7cac");
        message.setBody("{\n" +
                "  \"bookingId\" : 3115171,\n" +
                "  \"robotName\" : \"Now Booking Not Arrived\",\n" +
                "  \"problemType\" : \"NOW_BOOKING_NOT_ARRIVED\"\n" +
                "}");
        return message;
    }
}
