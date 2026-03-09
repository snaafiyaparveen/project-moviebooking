package com.moviebooking.controller;

import com.moviebooking.service.SeatLockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
@RequiredArgsConstructor
public class SeatController {

    private final SeatLockService seatLockService;

    @PostMapping("/lock")
    public String lockSeats(@RequestParam Long userId,
                            @RequestBody List<Long> seatIds) {

        seatLockService.lockSeats(userId, seatIds);
        return "Seats locked";
    }
}
