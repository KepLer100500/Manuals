package com.kepler.model;

import lombok.Data;


@Data
public class Message {
    private String message;
    private String routingKey;
}
