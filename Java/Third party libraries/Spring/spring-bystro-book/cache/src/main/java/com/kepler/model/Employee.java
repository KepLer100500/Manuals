package com.kepler.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalTime;


@Data
@AllArgsConstructor
public class Employee {
    private int id;
    private LocalTime creationTime;
    private String name;
}
