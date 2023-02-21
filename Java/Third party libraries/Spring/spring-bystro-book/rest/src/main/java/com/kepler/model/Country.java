package com.kepler.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class Country {
    @NonNull
    private String name;
    @NonNull
    private int population;
}
