package com.moviebooking.service;

import com.moviebooking.entity.ShowSeat;
import com.moviebooking.repository.ShowSeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatLockService {

    private final ShowSeatRepository showSeatRepository;

    public synchronized void lockSeats(Long userId, List<Long> seatIds) {

        List<ShowSeat> seats = showSeatRepository.findAllById(seatIds);

        for (ShowSeat seat : seats) {
            if (!seat.getStatus().equals("AVAILABLE")) {
                throw new RuntimeException("Seat already locked/booked");
            }
        }

        seats.forEach(seat -> {
            seat.setStatus("LOCKED");
            seat.setLockedBy(userId);
            seat.setLockedAt(LocalDateTime.now().toString());
        });

        showSeatRepository.saveAll(seats);
    }
}
