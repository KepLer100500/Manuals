package com.kepler.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class Product {
    @NonNull
    private String name;
    @NonNull
    private double price;
}
