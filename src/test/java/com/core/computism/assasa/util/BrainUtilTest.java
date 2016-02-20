package com.core.computism.assasa.util;

import com.core.computism.assasa.BaseUnitTest;
import com.core.computism.assasa.domain.IssueDTO;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

/**
 * Created by Venturedive on 8/25/2015.
 */
public class BrainUtilTest extends BaseUnitTest {

    @Test
    public void testGetBookingIds() {
        List<Integer> expected = Arrays.asList(1234, 5678);
        List<Integer> actual = BrainUtil.getBookingIds(getIssues());
        assertNotNull(actual);
        assertThat(actual, hasSize(4));
        assertThat(actual, hasItems(expected.get(0), expected.get(1)));
    }

    private List<IssueDTO> getIssues() {
        IssueDTO issueDTO1 = new IssueDTO();
        issueDTO1.setBookingId(1234);
        issueDTO1.setRobotName("Captain Not Assigned - Dubai");
        issueDTO1.setProblemType("CAPTAIN_NOT_ASSIGNED");

        IssueDTO issueDTO2 = new IssueDTO();
        issueDTO2.setBookingId(5678);
        issueDTO2.setRobotName("Captain Not Assigned - Dubai");
        issueDTO2.setProblemType("CAPTAIN_NOT_ASSIGNED");

        // Repeated Issue
        IssueDTO issueDTO3 = new IssueDTO();
        issueDTO3.setBookingId(1234);
        issueDTO3.setRobotName("Captain Not Assigned - Dubai");
        issueDTO3.setProblemType("CAPTAIN_NOT_ASSIGNED");

        // Same Booking with Different Problem Type
        IssueDTO issueDTO4 = new IssueDTO();
        issueDTO4.setBookingId(5678);
        issueDTO4.setRobotName("Now Booking Not Arrived");
        issueDTO4.setProblemType("NOW_BOOKING_NOT_ARRIVED");

        return Arrays.asList(issueDTO1, issueDTO2, issueDTO3, issueDTO4);
    }
}
