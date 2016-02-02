package com.core.computism.assetmanagementsystem.util;

import com.core.computism.assetmanagementsystem.domain.IssueDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venturedive on 8/24/2015.
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
