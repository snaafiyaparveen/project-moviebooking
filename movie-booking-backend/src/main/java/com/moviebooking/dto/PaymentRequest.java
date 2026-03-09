package com.moviebooking.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequest {

    private Long bookingId;
    private Double amount;
    private String paymentMethod; // CARD / UPI / NETBANKING
}
