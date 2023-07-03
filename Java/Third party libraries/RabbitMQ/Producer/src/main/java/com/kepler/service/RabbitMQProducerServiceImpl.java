package com.kepler.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQProducerServiceImpl implements RabbitMQProducerService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Override
    public void sendMessage(String message, String routingKey) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }
    
}
