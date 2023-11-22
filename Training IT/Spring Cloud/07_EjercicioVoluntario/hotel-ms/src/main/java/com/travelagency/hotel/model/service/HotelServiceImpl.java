package com.travelagency.hotel.model.service;

import com.travelagency.hotel.model.repository.HotelRepository;
import com.travelagency.hotel.model.repository.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<Hotel> getAvailableHotels() {
        return this.hotelRepository.findByAvailable(true);
    }

    @Override
    public Hotel getHotelByName(final String name) {
        return this.hotelRepository.findByName(name).orElseThrow();
    }

    @Override
    public Hotel getHotelById(final Integer id) {
        return this.hotelRepository.findById(id).orElseThrow();
    }

}
