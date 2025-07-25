package com.kepler;

import com.kepler.service.Grpc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class App {
    public static void main(String[] args) {
        var context = SpringApplication.run(App.class, args);

        Grpc grpc = context.getBean(Grpc.class);
        SignalResponse response = grpc.getSignal(123);
        log.info("Client get response: {}", response);
    }
}