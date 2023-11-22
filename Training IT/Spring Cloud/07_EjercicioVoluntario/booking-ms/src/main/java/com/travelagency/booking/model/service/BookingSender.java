package com.travelagency.booking.model.service;

import com.travelagency.booking.model.service.schema.BookingEventDTO;

public interface BookingSender {

    void sendBookingEvent(final BookingEventDTO bookingEvent);

}
