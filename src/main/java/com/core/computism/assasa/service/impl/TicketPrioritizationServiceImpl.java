package com.core.computism.assasa.service.impl;

import com.core.computism.assasa.domain.type.TicketPriority;
import com.core.computism.assasa.persistence.entity.ticket.BookingInfo;
import com.core.computism.assasa.persistence.entity.ticket.ProblemType;
import com.core.computism.assasa.service.ProblemTypeService;
import com.core.computism.assasa.service.TicketPrioritizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by M.Mustufa Amin Shah on 9/7/2015.
 */
@Service(value = "ticketPrioritizaitonService")
public class TicketPrioritizationServiceImpl implements TicketPrioritizationService {

    @Autowired private ProblemTypeService problemTypeService;

    @Override
    public TicketPriority calculate(BookingInfo bookingInfo, ProblemType problemType) {
        TicketPriority priority = TicketPriority.NORMAL;

        if (bookingInfo.getBookingStatus() < 4) {
            long timeToPickUp = getTimeToPickup(bookingInfo);

            if(timeToPickUp < 20 && isCriticalTicket(bookingInfo.getBookingType(), problemType)){
                priority = TicketPriority.CRITICAL;

            } else if(timeToPickUp <120){
                priority = TicketPriority.URGENT;
            }
        }
        return priority;
    }

    private boolean isCriticalTicket(Integer bookingType, ProblemType problemType) {
        return (bookingType == 1
                &&problemTypeService.isCriticalProblemType(problemType));
    }

    private long getTimeToPickup(BookingInfo bookingInfo){
        return ((bookingInfo.getPickupTime().getTime() - getCurrentTimeInMills()) / 60000);
    }

    public long getCurrentTimeInMills(){
        return System.currentTimeMillis();
    }
}