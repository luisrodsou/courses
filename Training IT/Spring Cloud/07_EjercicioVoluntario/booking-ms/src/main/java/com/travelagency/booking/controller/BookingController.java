package com.travelagency.booking.controller;

import com.travelagency.booking.model.service.BookingService;
import com.travelagency.booking.model.service.schema.BookingDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Mantenimiento de reservas")
@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Operation(summary = "Realiza una reserva")
    @PostMapping(value = "/bookings", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveBooking(@RequestBody final BookingDTO booking) {
        this.bookingService.saveBooking(booking);
    }

    @Operation(summary = "Obtiene las reservas de un determinado hotel")
    @GetMapping(value = "/bookings", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookingDTO> getBookings(@Parameter(description = "Nombre del hotel") @RequestParam("hotelName") final String hotelName) {
        return this.bookingService.getBookings(hotelName);
    }

}
