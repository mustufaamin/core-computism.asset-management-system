package com.core.computism.assetmanagementsystem.service;

import com.core.computism.assetmanagementsystem.exception.BrainBusinessException;
import com.core.computism.assetmanagementsystem.persistence.entity.booking.BookingDetail;
import com.core.computism.assetmanagementsystem.persistence.entity.ticket.BookingInfo;

/**
 * Created by Venturedive on 8/19/2015.
 */
public interface BookingInfoService {

    BookingInfo save(BookingDetail bookingDetail) throws BrainBusinessException;
}
