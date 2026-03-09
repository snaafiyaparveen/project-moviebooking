package com.moviebooking.notification;

import org.springframework.stereotype.Service;

@Service
public class SmsService {

    public void sendBookingSMS(String phoneNumber, String movieName, String showTime) {


        System.out.println("Sending SMS to " + phoneNumber);
        System.out.println("Movie: " + movieName + " Show: " + showTime);

    }

    public void sendOtpSMS(String phoneNumber, String otp) {

        System.out.println("Sending OTP to " + phoneNumber);

    }
}
