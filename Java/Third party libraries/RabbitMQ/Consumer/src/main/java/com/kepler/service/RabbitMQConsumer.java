package com.kepler.service;

import lombok.extern.java.Log;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.util.logging.Level;


@Component
@EnableRabbit
@Log
public class RabbitMQConsumer {
    @RabbitListener(queues = "${rabbitmq.queue}")
    public void processMyQueue(String message) {
        log.log(Level.INFO, "Received: {0}", new String(message.getBytes()));
    }
}
