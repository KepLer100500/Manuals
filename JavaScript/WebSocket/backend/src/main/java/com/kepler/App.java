package com.kepler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * curl -X POST http://localhost:8085/api/data/update -H "Content-Type: application/json" -d '{"field1":"111","field2":"222","field3":"333"}'
 */
@SpringBootApplication
@EnableScheduling
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
