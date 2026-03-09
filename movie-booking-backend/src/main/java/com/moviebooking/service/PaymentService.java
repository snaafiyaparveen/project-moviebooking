package com.moviebooking.service;

import com.moviebooking.entity.Booking;
import com.moviebooking.entity.Payment;
import com.moviebooking.repository.BookingRepository;
import com.moviebooking.repository.PaymentRepository;
import com.razorpay.*;
import com.razorpay.RazorpayClient;
import com.razorpay.Order;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final BookingRepository bookingRepository;

    public String createOrder(Long bookingId, Double amount) throws Exception {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        RazorpayClient client = new RazorpayClient("KEY", "SECRET");

        JSONObject options = new JSONObject();
        options.put("amount", amount * 100);
        options.put("currency", "INR");

        Order order = client.orders.create(options);

        Payment payment = new Payment();
        payment.setBooking(booking);
        payment.setTransactionId(order.get("id"));
        payment.setAmount(amount);
        payment.setCurrency("INR");
        payment.setStatus("INITIATED");

        paymentRepository.save(payment);

        return order.toString();
    }
}
