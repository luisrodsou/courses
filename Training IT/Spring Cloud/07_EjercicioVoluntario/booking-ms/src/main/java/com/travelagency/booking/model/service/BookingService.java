package com.travelagency.booking.model.service;

import com.travelagency.booking.model.service.schema.BookingConfirmationEventDTO;
import com.travelagency.booking.model.service.schema.BookingDTO;

import java.util.List;

public interface BookingService {

    void saveBooking(final BookingDTO booking);

    List<BookingDTO> getBookings(final String hotelName);

    void updateBookingStatus(final BookingConfirmationEventDTO bookingConfirmationEvent);

}
