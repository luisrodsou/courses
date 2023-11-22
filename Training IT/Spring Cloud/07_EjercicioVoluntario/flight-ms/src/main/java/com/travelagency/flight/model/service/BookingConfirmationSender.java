package com.travelagency.flight.model.service;

import com.travelagency.flight.model.service.schema.BookingConfirmationEventDTO;

public interface BookingConfirmationSender {

    void sendBookingConfirmationEvent(final BookingConfirmationEventDTO bookingConfirmationEvent);

}
