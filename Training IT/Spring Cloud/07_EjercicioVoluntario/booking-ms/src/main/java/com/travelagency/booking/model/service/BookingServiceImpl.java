package com.travelagency.booking.model.service;

import com.travelagency.booking.model.repository.BookingRepository;
import com.travelagency.booking.model.repository.entity.Booking;
import com.travelagency.booking.model.service.schema.BookingConfirmationEventDTO;
import com.travelagency.booking.model.service.schema.BookingDTO;
import com.travelagency.booking.model.service.schema.BookingEventDTO;
import com.travelagency.booking.model.service.schema.HotelDTO;
import com.travelagency.booking.model.service.util.BookingStatus;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private HotelClient hotelClient;

    @Autowired
    private BookingSender bookingSender;

    @Autowired
    private BookingRepository bookingRepository;

    @Transactional
    @Override
    public void saveBooking(final BookingDTO booking) {
        final HotelDTO hotel = this.hotelClient.getHotelById(booking.getHotelId()).orElseThrow();

        if (!hotel.getAvailable()) {
            throw new IllegalArgumentException("El hotel no está disponible");
        }

        final Booking entity = new Booking();

        entity.setClientName(booking.getName());
        entity.setDni(booking.getDni());
        entity.setHotelId(booking.getHotelId());
        entity.setFlightId(booking.getFlightId());
        entity.setStatusId(BookingStatus.PENDING_FLIGHT.getId());

        this.bookingRepository.save(entity);

        final BookingEventDTO bookingEvent = new BookingEventDTO(entity.getId(), entity.getFlightId(), booking.getPeopleCount());

        this.bookingSender.sendBookingEvent(bookingEvent);
    }

    @Override
    public List<BookingDTO> getBookings(final String hotelName) {
        final Integer hotelId = this.hotelClient.getHotelByName(hotelName).orElseThrow().getId();
        final List<Booking> entities = this.bookingRepository.findByHotelId(hotelId);
        final List<BookingDTO> bookings = new ArrayList<>();

        for (final Booking entity : entities) {
            bookings.add(new BookingDTO(entity.getClientName(), entity.getDni(), entity.getFlightId()));
        }

        return bookings;
    }

    @Transactional
    @Override
    public void updateBookingStatus(final BookingConfirmationEventDTO bookingConfirmationEvent) {
        final Booking booking = this.bookingRepository.findById(bookingConfirmationEvent.getBookingId()).orElse(null);

        if (booking != null) {
            final BookingStatus nextStatus = bookingConfirmationEvent.getConfirmed()
                    ? BookingStatus.ACCEPTED : BookingStatus.REJECTED;

            booking.setStatusId(nextStatus.getId());
        }
    }

}
