package com.moviebooking.service;

import com.moviebooking.dto.BookingRequest;
import com.moviebooking.entity.*;
import com.moviebooking.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingSeatRepository bookingSeatRepository;
    private final ShowSeatRepository showSeatRepository;

    public Booking createBooking(BookingRequest request) {

        Booking booking = new Booking();
        booking.setUserId(request.getUserId());
        booking.setShowId(request.getShowId());
        booking.setStatus("PENDING");
        booking.setPaymentStatus("UNPAID");
        booking.setCreatedAt(LocalDateTime.now().toString());

        bookingRepository.save(booking);

        List<ShowSeat> showSeats = showSeatRepository.findAllById(request.getShowSeatIds());

        List<BookingSeat> bookingSeats = new ArrayList<>();

        for (ShowSeat ss : showSeats) {

            ss.setStatus("BOOKED");
            showSeatRepository.save(ss);

            BookingSeat bs = new BookingSeat();
            bs.setBooking(booking);
            bs.setSeat(ss.getSeat());
            bs.setPrice(request.getPrice());
            bs.setSeatType(ss.getSeat().getSeatType());

            bookingSeats.add(bs);
        }

        bookingSeatRepository.saveAll(bookingSeats);

        booking.setSeats(bookingSeats);
        booking.setStatus("CONFIRMED");

        return bookingRepository.save(booking);
    }
}
