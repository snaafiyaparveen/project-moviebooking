package com.moviebooking.controller;

import com.moviebooking.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/booking")
    public String sendBookingNotification(@RequestParam String email) {
        notificationService.sendBookingNotification(email);
        return "Email sent";
    }
}
