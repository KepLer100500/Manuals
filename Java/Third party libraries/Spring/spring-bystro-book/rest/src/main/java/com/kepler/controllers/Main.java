package com.kepler.controllers;

import com.kepler.exception.NotEnoughMoneyException;
import com.kepler.model.Country;
import com.kepler.model.ErrorDetails;
import com.kepler.model.PaymentDetails;
import com.kepler.service.PaymentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main {
    @Autowired
    private PaymentService paymentService;
    
    @GetMapping("/country/{countryName}")
    public Country getCountry(@PathVariable String countryName) {
        // curl -o localhost.html http://localhost/country/Russia; cat localhost.html
        Country country = Country.builder().name(countryName).population(500).build();
        return country;
    }
    
    @GetMapping("/country/all")
    public List<Country> getAllCountries(@RequestParam(required = true) int populationCount) {
        // curl -o localhost.html http://localhost/country/all?populationCount=33; cat localhost.html
        return List.of(
            Country.builder().name("Spain").population(populationCount).build(),
            Country.builder().name("France").population(populationCount).build()
        );
    }
    
    @GetMapping("/country/France")
    public ResponseEntity<Country> getFrance() {
        // curl -v http://localhost/country/France
        Country country = Country.builder().name("France").population(333).build();
        return ResponseEntity
                .status(HttpStatus.ACCEPTED) // status -> 202
                .header("Continente", "Europe")
                .header("Capital", "Paris")
                .header("Favorite food", "Cheese")
                .body(country);
    }
    
    @PostMapping("/payment")
    public ResponseEntity<?> makePayment() {
        // curl -X POST -o localhost.html http://localhost/payment; cat localhost.html
        try {
            PaymentDetails paymentDetails = paymentService.processPayment();
            
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(paymentDetails);
        } catch (NotEnoughMoneyException e) {
            ErrorDetails errorDetails = 
                    new ErrorDetails("Not enough money for make payment.");
            
            return ResponseEntity.badRequest().body(errorDetails);
        }
    }
    
    @PostMapping("/payment-advice")
    public ResponseEntity<PaymentDetails> makePaymentWithAdvice() {
        // curl -X POST -o localhost.html http://localhost/payment-advice; cat localhost.html
        PaymentDetails paymentDetails = paymentService.processPayment();
        
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(paymentDetails);
    }
    
    @PostMapping("/payment-in-body-parameters")
    public ResponseEntity<PaymentDetails> makePaymenWithBodyParameters(
            @RequestBody PaymentDetails paymentDetails) {
        // curl -X POST http://localhost/payment-in-body-parameters -d '{"amount": 500}' -H "Content-Type: application/json" -o localhost.html ; cat localhost.html
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(paymentDetails);
    }
}
