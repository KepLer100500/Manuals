package com.kepler.service;


public interface RabbitMQProducerService {
    void sendMessage(String message, String routingKey);
}
