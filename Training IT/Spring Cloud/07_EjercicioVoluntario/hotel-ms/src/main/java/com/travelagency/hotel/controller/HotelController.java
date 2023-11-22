package com.travelagency.hotel.controller;

import com.travelagency.hotel.model.repository.entity.Hotel;
import com.travelagency.hotel.model.service.HotelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Mantenimiento de hoteles")
@RestController
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Operation(summary = "Obtiene todos los hoteles disponibles")
    @GetMapping(value = "/hotels/available", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Hotel> getAvailableHotels() {
        return this.hotelService.getAvailableHotels();
    }

    @Operation(summary = "Obtiene los datos de un hotel a partir de su nombre")
    @GetMapping(value = "/hotel", produces = MediaType.APPLICATION_JSON_VALUE)
    public Hotel getHotelByName(@Parameter(description = "Nombre del hotel") @RequestParam("name") final String name) {
        return this.hotelService.getHotelByName(name);
    }

    @Operation(summary = "Obtiene los datos de un hotel a partir de su identificador")
    @GetMapping(value = "/hotel/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Hotel getHotelById(@Parameter(description = "Identificador del hotel") @PathVariable("id") final Integer id) {
        return this.hotelService.getHotelById(id);
    }

}
