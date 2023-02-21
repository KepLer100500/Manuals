package com.kepler.proxies;

import com.kepler.model.Payment;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PaymentProxy {
    private static final Logger logger = 
            Logger.getLogger(PaymentProxy.class.getName());

    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${point.url}")
    private String paymentServiceUrl;
    
    public Payment createPayment(Payment payment) {
        String url = paymentServiceUrl + "/payment";
        String requestId = UUID.randomUUID().toString();
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("requestId", requestId);
        
        HttpEntity<Payment> httpEntity = new HttpEntity<>(payment, headers);
        
        ResponseEntity<Payment> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                httpEntity,
                Payment.class
        );
        logger.log(Level.INFO, "Generated id: {0}", requestId);
        
        return response.getBody();
    }
}
