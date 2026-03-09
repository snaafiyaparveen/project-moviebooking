package com.moviebooking.util;

import com.moviebooking.entity.Screen;
import com.moviebooking.entity.Seat;

import java.util.ArrayList;
import java.util.List;

public class SeatLayoutGenerator {

    public static List<Seat> generateSeats(Screen screen,
                                           int rows,
                                           int seatsPerRow) {

        List<Seat> seats = new ArrayList<>();

        for (int i = 0; i < rows; i++) {

            char rowLabel = (char) ('A' + i);

            for (int j = 1; j <= seatsPerRow; j++) {

                Seat seat = new Seat();
                seat.setRowLabel(String.valueOf(rowLabel));
                seat.setSeatNumber(j);
                seat.setScreen(screen);

                if (i < rows * 0.6) {
                    seat.setSeatType("REGULAR");
                } else if (i < rows * 0.85) {
                    seat.setSeatType("PREMIUM");
                } else {
                    seat.setSeatType("RECLINER");
                }

                seats.add(seat);
            }
        }

        return seats;
    }
}
