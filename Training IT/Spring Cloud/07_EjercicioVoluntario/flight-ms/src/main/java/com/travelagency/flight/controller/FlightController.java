package com.travelagency.flight.controller;

import com.travelagency.flight.model.repository.entity.Flight;
import com.travelagency.flight.model.service.FlightService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Mantenimiento de vuelos")
@RestController
public class FlightController {

    @Autowired
    private FlightService flightService;


    @Operation(summary = "Obtiene todos los vuelos disponibles")
    @GetMapping(value = "/flights/available", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Flight> getAvailableFlights(@Parameter(description = "Número de plazas requeridas") @RequestParam("requiredSeats") final Short requiredSeats) {
        return this.flightService.getAvailableFlights(requiredSeats);
    }

    @Operation(summary = "Reserva plazas en un vuelo")
    @PutMapping(value = "/flight/{id}")
    public void bookSeats(@Parameter(description = "Identificador del vuelo") @PathVariable("id") final Integer flightId,
                          @Parameter(description = "Número de plazas a reservar") @RequestParam("seats") final Short seats) {
        this.flightService.bookSeats(flightId, seats);
    }

}
