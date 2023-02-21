package org.kepler.abstractionsWithSpring.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class Comment {
    @NonNull
    private String author;
    @NonNull
    private String text;
}
