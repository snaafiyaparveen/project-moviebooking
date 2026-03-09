package com.moviebooking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Show show;

    @ManyToOne
    private Seat seat;

    private String status; // AVAILABLE LOCKED BOOKED
    private Long lockedBy;
    private String lockedAt;
}
