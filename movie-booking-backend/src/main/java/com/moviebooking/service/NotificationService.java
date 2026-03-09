package com.moviebooking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final EmailService emailService;

    public void sendBookingNotification(String email) {
        emailService.sendBookingConfirmation(email);
    }

    public void sendCancellationNotification(String email) {
        emailService.sendBookingConfirmation(email);
    }
}
