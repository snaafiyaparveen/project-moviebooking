package com.moviebooking.service;

import com.moviebooking.entity.Seat;
import com.moviebooking.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatService {

    private final SeatRepository seatRepository;

    public Seat addSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public List<Seat> getSeatsByScreen(Long screenId) {
        return seatRepository.findAll()
                .stream()
                .filter(seat -> seat.getScreen().getId().equals(screenId))
                .toList();
    }

    public void deleteSeat(Long id) {
        seatRepository.deleteById(id);
    }
}
