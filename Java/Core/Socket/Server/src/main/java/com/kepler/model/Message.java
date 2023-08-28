package com.kepler.model;

import lombok.Builder;
import lombok.Data;
import java.time.LocalTime;
import java.util.UUID;


@Data
@Builder
public class Message {
    private UUID uuid;
    private String text;
    private LocalTime dateTime;
}
