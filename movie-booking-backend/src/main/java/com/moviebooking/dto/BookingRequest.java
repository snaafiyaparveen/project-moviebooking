package com.moviebooking.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingRequest {
    private Long userId;
    private Long showId;
    private double price;
    private List<Long> showSeatIds;
}
