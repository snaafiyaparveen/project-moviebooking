package com.moviebooking.payment;

import com.moviebooking.entity.Booking;
import com.moviebooking.entity.Payment;
import com.moviebooking.repository.BookingRepository;
import com.moviebooking.repository.PaymentRepository;
import com.razorpay.*;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentGatewayService {

    private final RazorpayClient razorpayClient;
    private final BookingRepository bookingRepository;
    private final PaymentRepository paymentRepository;

    public String createRazorpayOrder(Long bookingId, Double amount) throws Exception {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        JSONObject options = new JSONObject();
        options.put("amount", amount * 100);
        options.put("currency", "INR");

        Order order = razorpayClient.orders.create(options);

        Payment payment = new Payment();
        payment.setBooking(booking);
        payment.setTransactionId(order.get("id"));
        payment.setAmount(amount);
        payment.setCurrency("INR");
        payment.setStatus("INITIATED");
        payment.setPaymentMethod("RAZORPAY");

        paymentRepository.save(payment);

        return order.toString();
    }

    public void markPaymentSuccess(String transactionId) {

        Payment payment = paymentRepository
                .findByTransactionId(transactionId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        payment.setStatus("SUCCESS");
        paymentRepository.save(payment);

        Booking booking = payment.getBooking();
        booking.setPaymentStatus("PAID");

        bookingRepository.save(booking);
    }

    public void markPaymentFailed(String transactionId) {

        Payment payment = paymentRepository
                .findByTransactionId(transactionId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        payment.setStatus("FAILED");
        paymentRepository.save(payment);
    }
}
