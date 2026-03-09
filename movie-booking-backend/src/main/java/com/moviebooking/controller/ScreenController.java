package com.moviebooking.controller;

import com.moviebooking.entity.Screen;
import com.moviebooking.service.ScreenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/screens")
@RequiredArgsConstructor
public class ScreenController {

    private final ScreenService screenService;

    @PostMapping
    public Screen add(@RequestBody Screen screen) {
        return screenService.addScreen(screen);
    }

    @GetMapping
    public List<Screen> getAll() {
        return screenService.getAllScreens();
    }
}
