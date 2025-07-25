package com.kepler.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Signal {
    int id;
    String title;
    LocalDateTime timestamp;
    double value;
}
