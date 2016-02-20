package com.core.computism.assasa.service;

import com.core.computism.assasa.domain.type.TicketPriority;
import com.core.computism.assasa.persistence.entity.ticket.BookingInfo;
import com.core.computism.assasa.persistence.entity.ticket.ProblemType;

/**
 * Created by Venture Dive on 9/7/2015.
 */
public interface TicketPrioritizationService {

    TicketPriority calculate(BookingInfo bookingInfo, ProblemType problemType);
}
