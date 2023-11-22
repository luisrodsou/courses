package com.travelagency.flight.model.service;

import com.travelagency.flight.model.repository.FlightRepository;
import com.travelagency.flight.model.repository.entity.Flight;
import com.travelagency.flight.model.service.schema.BookingConfirmationEventDTO;
import com.travelagency.flight.model.service.schema.BookingEventDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private BookingConfirmationSender bookingConfirmationSender;

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<Flight> getAvailableFlights(final Short requiredSeats) {
        return this.flightRepository.findByAvailableSeatsGreaterThanEqual(requiredSeats);
    }

    @Transactional
    @Override
    public void bookSeats(final Integer flightId, final Short seats) {
        final Flight flight = this.flightRepository.findById(flightId).orElseThrow();
        final short resultSeats = (short) (flight.getAvailableSeats() - seats);

        if (resultSeats < 0) {
            throw new IllegalArgumentException("No hay suficientes plazas en el vuelo");
        }

        flight.setAvailableSeats(resultSeats);
    }

    @Transactional
    @Override
    public void bookSeats(final BookingEventDTO bookingEvent) {
        final Flight flight = this.flightRepository.findById(bookingEvent.getFlightId()).orElse(null);
        final BookingConfirmationEventDTO event = new BookingConfirmationEventDTO(bookingEvent.getBookingId(), false);

        if (flight != null) {
            final short resultSeats = (short) (flight.getAvailableSeats() - bookingEvent.getSeats());

            if (resultSeats >= 0) {
                flight.setAvailableSeats(resultSeats);

                this.flightRepository.save(flight);

                event.setConfirmed(true);
            }
        }

        this.bookingConfirmationSender.sendBookingConfirmationEvent(event);
    }

}
