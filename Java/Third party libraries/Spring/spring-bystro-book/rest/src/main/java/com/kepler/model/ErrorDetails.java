package com.kepler.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class ErrorDetails {
    @NonNull
    private String message;
}
