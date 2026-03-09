package com.moviebooking.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationEmailService {

    private final JavaMailSender mailSender;

    public void sendBookingConfirmation(String email, String movieName, String showTime) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Booking Confirmed 🎬");

        message.setText(
                "Your booking is confirmed!\n\n" +
                        "Movie: " + movieName + "\n" +
                        "Show Time: " + showTime + "\n\n" +
                        "Enjoy your movie!"
        );

        mailSender.send(message);
    }

    public void sendPaymentReceipt(String email, Double amount) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Payment Successful");

        message.setText(
                "Payment received successfully.\n\n" +
                        "Amount: ₹" + amount
        );

        mailSender.send(message);
    }

    public void sendCancellationMail(String email, String movieName) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Booking Cancelled");

        message.setText(
                "Your booking for " + movieName + " has been cancelled."
        );

        mailSender.send(message);
    }
}
