package com.travelagency.booking.model.repository;

import com.travelagency.booking.model.repository.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    List<Booking> findByHotelId(final Integer hotelId);

}
