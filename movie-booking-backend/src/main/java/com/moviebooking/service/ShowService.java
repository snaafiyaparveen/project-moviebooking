package com.moviebooking.service;

import com.moviebooking.entity.*;
import com.moviebooking.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowService {

    private final ShowRepository showRepository;
    private final SeatRepository seatRepository;
    private final ShowSeatRepository showSeatRepository;

    public Show createShow(Show show) {

        Show savedShow = showRepository.save(show);

        List<Seat> seats = seatRepository.findAll();

        for (Seat seat : seats) {
            ShowSeat ss = new ShowSeat();
            ss.setShow(savedShow);
            ss.setSeat(seat);
            ss.setStatus("AVAILABLE");

            showSeatRepository.save(ss);
        }

        return savedShow;
    }

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }
}
