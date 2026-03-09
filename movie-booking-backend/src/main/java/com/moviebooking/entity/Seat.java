package com.moviebooking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rowLabel;
    private Integer seatNumber;
    private String seatType;

    @ManyToOne
    private Screen screen;
}
