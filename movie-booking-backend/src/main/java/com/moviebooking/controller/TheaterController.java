package com.moviebooking.controller;

import com.moviebooking.entity.Theater;
import com.moviebooking.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theaters")
@RequiredArgsConstructor
public class TheaterController {

    private final TheaterService theaterService;

    @PostMapping
    public Theater add(@RequestBody Theater theater) {
        return theaterService.addTheater(theater);
    }

    @GetMapping
    public List<Theater> all() {
        return theaterService.getAllTheaters();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        theaterService.deleteTheater(id);
    }
}
