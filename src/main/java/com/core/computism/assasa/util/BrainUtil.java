package com.core.computism.assasa.util;

import com.core.computism.assasa.domain.IssueDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Salman on 8/24/2015.
 */
public class BrainUtil {

   public static List<Integer> getBookingIds (List<IssueDTO> issueDTOs) {
        List<Integer> bookingIds = new ArrayList<>(issueDTOs.size());
        for (IssueDTO issueDTO : issueDTOs) {
            bookingIds.add(issueDTO.getBookingId());
        }
        return bookingIds;
    }
}
