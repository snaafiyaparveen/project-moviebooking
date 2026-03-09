package com.moviebooking.controller;

import com.moviebooking.entity.Show;
import com.moviebooking.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shows")
@RequiredArgsConstructor
public class ShowController {

    private final ShowService showService;

    @PostMapping
    public Show create(@RequestBody Show show) {
        return showService.createShow(show);
    }

    @GetMapping
    public List<Show> all() {
        return showService.getAllShows();
    }
}
