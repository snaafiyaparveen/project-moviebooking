package com.moviebooking.controller;

import com.moviebooking.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/create-order")
    public String createOrder(@RequestParam Long bookingId,
                              @RequestParam Double amount) throws Exception {
        return paymentService.createOrder(bookingId, amount);
    }
}
