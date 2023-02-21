package com.kepler.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Developer {
    private Long id;
    private String name;
    private String language;

    public static List<Developer> makeDefaultDeveloperList() {
        return Stream.of(
                Developer.builder().id(1L).name("Bart").language("Java").build(),
                Developer.builder().id(2L).name("Mike").language("Python").build(),
                Developer.builder().id(3L).name("Zed").language("JS").build()
        ).collect(Collectors.toList());
    }
}
