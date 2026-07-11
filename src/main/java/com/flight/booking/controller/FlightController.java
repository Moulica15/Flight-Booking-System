package com.flight.booking.controller;

import com.flight.booking.entity.Flight;
import com.flight.booking.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService service;

    @PostMapping
    public ResponseEntity<Flight> createFlight(
            @RequestBody Flight flight) {

        Flight created = service.createFlight(flight);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(created);
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return service.getAllFlights();
    }

    @GetMapping("/{id}")
    public Flight getFlightById(@PathVariable Long id) {
        return service.getFlightById(id);
    }

    @GetMapping("/source/{source}")
    public List<Flight> getFlightsBySource(
            @PathVariable String source) {

        return service.getFlightsBySource(source);
    }

    @GetMapping("/price/{price}")
    public List<Flight> getExpensiveFlights(
            @PathVariable Double price) {

        return service.getExpensiveFlights(price);
    }

    @GetMapping("/count/{destination}")
    public Long countFlights(
            @PathVariable String destination) {

        return service.countFlights(destination);
    }

    @PutMapping("/{id}")
    public Flight updateFlight(@PathVariable Long id,
                               @RequestBody Flight flight) {

        return service.updateFlight(id, flight);
    }

    @PatchMapping("/{id}")
    public Flight patchFlight(@PathVariable Long id,
                              @RequestBody Flight flight) {

        return service.patchFlight(id, flight);
    }

    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable Long id) {
        service.deleteFlight(id);
    }
}