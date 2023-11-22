package com.travelagency.flight.model.service;

import com.travelagency.flight.model.repository.entity.Flight;
import com.travelagency.flight.model.service.schema.BookingEventDTO;

import java.util.List;

public interface FlightService {

    List<Flight> getAvailableFlights(final Short requiredSeats);

    void bookSeats(final Integer flightId, final Short seats);

    void bookSeats(final BookingEventDTO bookingEvent);

}
