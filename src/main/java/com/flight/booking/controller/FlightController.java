package com.flight.booking.controller;



import com.flight.booking.dto.request.FlightRequestDTO;
import com.flight.booking.dto.response.FlightResponseDTO;
import com.flight.booking.service.FlightServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightServiceImpl service;

    @PostMapping
    public ResponseEntity<FlightResponseDTO> createFlight(
            @Valid @RequestBody FlightRequestDTO dto) {

        FlightResponseDTO response = service.createFlight(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public List<FlightResponseDTO> getAllFlights() {
        return service.getAllFlights();
    }

    @GetMapping("/search")
    public Page<FlightResponseDTO> searchFlights(

            @RequestParam String from,

            @RequestParam String to,

            @RequestParam(defaultValue = "0") int page,

            @RequestParam(defaultValue = "5") int size

    ) {

        return service.searchFlights(from, to, page, size);

    }

    @GetMapping("/{id}")
    public FlightResponseDTO getFlightById(@PathVariable Long id) {
        return service.getFlightById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlightResponseDTO> updateFlight(
            @PathVariable Long id,
            @Valid @RequestBody FlightRequestDTO dto) {

        FlightResponseDTO response = service.updateFlight(id, dto);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {

        service.deleteFlight(id);

        return ResponseEntity.noContent().build();
    }
}