package com.travelagency.hotel.model.repository;

import com.travelagency.hotel.model.repository.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    List<Hotel> findByAvailable(final Boolean available);

    Optional<Hotel> findByName(final String name);

}
