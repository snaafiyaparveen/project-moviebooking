package com.moviebooking.controller;

import com.moviebooking.entity.Movie;
import com.moviebooking.entity.Theater;
import com.moviebooking.service.MovieService;
import com.moviebooking.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    @Autowired
    private final MovieService movieService;
    @Autowired
    private final TheaterService theaterService;

    @PostMapping("/movie")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @PostMapping("/theater")
    public Theater addTheater(@RequestBody Theater theater) {
        return theaterService.addTheater(theater);
    }
}
