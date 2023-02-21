package com.kepler.service;

import com.kepler.exception.NotEnoughMoneyException;
import com.kepler.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}
