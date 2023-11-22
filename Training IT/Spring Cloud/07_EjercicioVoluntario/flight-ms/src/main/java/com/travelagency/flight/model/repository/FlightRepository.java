package com.travelagency.flight.model.repository;

import com.travelagency.flight.model.repository.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    List<Flight> findByAvailableSeatsGreaterThanEqual(final Short availableSeats);

}
