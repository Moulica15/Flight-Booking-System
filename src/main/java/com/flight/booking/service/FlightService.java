package com.flight.booking.service;

import com.flight.booking.entity.Flight;
import com.flight.booking.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository repository;

    public Flight createFlight(Flight flight) {
        return repository.save(flight);
    }

    public List<Flight> getAllFlights() {
        return repository.findAll();
    }

    public Flight getFlightById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Flight not found"));
    }

    public Flight updateFlight(Long id, Flight updatedFlight) {

        Flight existingFlight = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Flight not found"));

        existingFlight.setFlightNumber(updatedFlight.getFlightNumber());
        existingFlight.setAirline(updatedFlight.getAirline());
        existingFlight.setSource(updatedFlight.getSource());
        existingFlight.setDestination(updatedFlight.getDestination());
        existingFlight.setDepartureTime(updatedFlight.getDepartureTime());
        existingFlight.setArrivalTime(updatedFlight.getArrivalTime());
        existingFlight.setPrice(updatedFlight.getPrice());
        existingFlight.setAvailableSeats(updatedFlight.getAvailableSeats());

        return repository.save(existingFlight);
    }

    public List<Flight> getFlightsBySource(String source) {
        return repository.searchBySource(source);
    }

    public List<Flight> getExpensiveFlights(Double price) {
        return repository.findExpensiveFlights(price);
    }

    public Long countFlights(String destination) {
        return repository.countFlights(destination);
    }

    public Flight patchFlight(Long id, Flight flight) {

        Flight existingFlight = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Flight not found"));

        if (flight.getFlightNumber() != null) {
            existingFlight.setFlightNumber(flight.getFlightNumber());
        }

        if (flight.getAirline() != null) {
            existingFlight.setAirline(flight.getAirline());
        }

        if (flight.getSource() != null) {
            existingFlight.setSource(flight.getSource());
        }

        if (flight.getDestination() != null) {
            existingFlight.setDestination(flight.getDestination());
        }

        if (flight.getDepartureTime() != null) {
            existingFlight.setDepartureTime(flight.getDepartureTime());
        }

        if (flight.getArrivalTime() != null) {
            existingFlight.setArrivalTime(flight.getArrivalTime());
        }

        if (flight.getPrice() != null) {
            existingFlight.setPrice(flight.getPrice());
        }

        if (flight.getAvailableSeats() != null) {
            existingFlight.setAvailableSeats(flight.getAvailableSeats());
        }

        return repository.save(existingFlight);
    }

    public void deleteFlight(Long id) {
        repository.deleteById(id);
    }
}