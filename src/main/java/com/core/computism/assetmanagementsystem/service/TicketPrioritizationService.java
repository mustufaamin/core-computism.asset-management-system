package com.core.computism.assetmanagementsystem.service;

import com.core.computism.assetmanagementsystem.domain.type.TicketPriority;
import com.core.computism.assetmanagementsystem.persistence.entity.ticket.BookingInfo;
import com.core.computism.assetmanagementsystem.persistence.entity.ticket.ProblemType;

/**
 * Created by Venture Dive on 9/7/2015.
 */
public interface TicketPrioritizationService {

    TicketPriority calculate(BookingInfo bookingInfo, ProblemType problemType);
}
