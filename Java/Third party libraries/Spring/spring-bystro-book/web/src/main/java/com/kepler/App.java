package com.kepler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.kepler")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
