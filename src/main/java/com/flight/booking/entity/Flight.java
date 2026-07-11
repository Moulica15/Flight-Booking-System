package com.flight.booking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;



@Entity
@Table(name = "flights")
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(
                name = "Flight.findBySource",
                query = "SELECT f FROM Flight f WHERE f.source = :source"
        ),
        @NamedQuery(
                name = "Flight.findHighPrice",
                query = "SELECT f FROM Flight f WHERE f.price > :minPrice ORDER BY f.price DESC"
        ),
        @NamedQuery(
                name = "Flight.countByDestination",
                query = "SELECT COUNT(f) FROM Flight f WHERE f.destination = :destination"
        )
})
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String flightNumber;

    @Column(nullable = false)
    private String airline;

    private String source;

    private String destination;

    private LocalDateTime departureTime;

    private LocalDateTime arrivalTime;

    private Double price;

    private Integer availableSeats;
}