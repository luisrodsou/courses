package com.travelagency.booking.model.service;

import com.travelagency.booking.model.service.schema.HotelDTO;

import java.util.Optional;

public interface HotelClient {

    Optional<HotelDTO> getHotelByName(final String name);

    Optional<HotelDTO> getHotelById(final Integer id);

}
