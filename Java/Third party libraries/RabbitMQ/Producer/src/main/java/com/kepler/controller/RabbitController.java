package com.kepler.controller;

import com.kepler.model.Message;
import com.kepler.service.RabbitMQProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RabbitController {
    @Autowired
    private RabbitMQProducerService rabbitMQProducerService;

    @GetMapping("/send")
    public void sendMessageToRabbit(@RequestBody Message message) {
        rabbitMQProducerService.sendMessage(message.getMessage(), message.getRoutingKey());
    }
}
