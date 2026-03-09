package com.moviebooking.service;

import com.moviebooking.entity.Theater;
import com.moviebooking.repository.TheaterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TheaterService {

    private final TheaterRepository theaterRepository;

    public Theater addTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    public Theater getTheater(Long id) {
        return theaterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Theater not found"));
    }

    public void deleteTheater(Long id) {
        theaterRepository.deleteById(id);
    }
}
