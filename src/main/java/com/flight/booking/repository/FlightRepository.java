package com.flight.booking.repository;

import com.flight.booking.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    Page<Flight> findByFromAirport_AirportCodeAndToAirport_AirportCode(
            String fromAirport,
            String toAirport,
            Pageable pageable
    );
}