package org.kepler;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;


@Getter
public class Book {
    @Value("${book.name}")
    private String name;

    @Value("${book.year}")
    private int year;

}