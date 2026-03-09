package com.moviebooking.controller;

import com.moviebooking.dto.BookingRequest;
import com.moviebooking.entity.Booking;
import com.moviebooking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public Booking create(@RequestBody BookingRequest request) {
        return bookingService.createBooking(request);
    }
}
