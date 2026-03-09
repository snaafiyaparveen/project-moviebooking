package com.moviebooking.service;

import com.moviebooking.entity.Screen;
import com.moviebooking.repository.ScreenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScreenService {

    private final ScreenRepository screenRepository;

    public Screen addScreen(Screen screen) {
        return screenRepository.save(screen);
    }

    public List<Screen> getAllScreens() {
        return screenRepository.findAll();
    }

    public Screen getScreen(Long id) {
        return screenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Screen not found"));
    }

    public void deleteScreen(Long id) {
        screenRepository.deleteById(id);
    }
}
