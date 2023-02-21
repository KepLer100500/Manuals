package com.kepler.controllers;

import com.kepler.model.Payment;
import com.kepler.proxies.PaymentProxy;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private static final Logger logger = 
            Logger.getLogger(PaymentController.class.getName());

    @Autowired
    private PaymentProxy paymentProxy;
    
    @PostMapping("/payment")
    public Payment createPayment(@RequestBody Payment payment) {
        logger.info("=== Request ===");
        logger.log(Level.INFO, "Request payment: {0}", payment);
        return paymentProxy.createPayment(payment);
    }
}
