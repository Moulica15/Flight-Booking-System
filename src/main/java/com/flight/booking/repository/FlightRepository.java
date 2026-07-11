package com.flight.booking.repository;

import com.flight.booking.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findBySource(String source);

    List<Flight> findByDestination(String destination);

    List<Flight> findByPriceGreaterThan(Double price);

    @Query(name = "Flight.findBySource")
    List<Flight> searchBySource(@Param("source") String source);

    @Query(name = "Flight.findHighPrice")
    List<Flight> searchHighPrice(@Param("minPrice") Double minPrice);

    @Query(name = "Flight.countByDestination")
    Long countFlights(@Param("destination") String destination);

    @Query("""
            SELECT f FROM Flight f
            WHERE f.price > :minPrice
            ORDER BY f.price DESC
            """)
    List<Flight> findExpensiveFlights(
            @Param("minPrice") Double minPrice);
}