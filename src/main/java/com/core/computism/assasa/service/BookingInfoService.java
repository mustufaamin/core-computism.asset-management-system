package com.core.computism.assasa.service;

import com.core.computism.assasa.exception.BrainBusinessException;
import com.core.computism.assasa.persistence.entity.booking.BookingDetail;
import com.core.computism.assasa.persistence.entity.ticket.BookingInfo;

/**
 * Created by Venturedive on 8/19/2015.
 */
public interface BookingInfoService {

    BookingInfo save(BookingDetail bookingDetail) throws BrainBusinessException;
}
