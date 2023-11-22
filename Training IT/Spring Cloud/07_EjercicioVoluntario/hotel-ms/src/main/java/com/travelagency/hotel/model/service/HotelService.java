package com.travelagency.hotel.model.service;

import com.travelagency.hotel.model.repository.entity.Hotel;

import java.util.List;

public interface HotelService {

    List<Hotel> getAvailableHotels();

    Hotel getHotelByName(final String name);

    Hotel getHotelById(final Integer id);

}
