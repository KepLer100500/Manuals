package com.kepler;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    private static final Logger logger = Logger.getLogger(MainController.class.getName());
    
    @PostMapping("/payment")
    public ResponseEntity<Payment> createPayment(
            @RequestHeader String requestId, 
            @RequestBody Payment payment) {
        // PORT = 81 !!!
        // curl -X POST http://localhost:81/payment -d '{"amount": 500}' -H "Content-Type: application/json" -H "requestId: 123" -o localhost.html ; cat localhost.html
        logger.info("=== Input request ===");
        logger.log(Level.INFO, "requestId: {0}", requestId);
        logger.log(Level.INFO, "Payment: {0}", payment.toString());
        
        String id = UUID.randomUUID().toString();
        payment.setId(id);
        
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(payment);
    }    
}
