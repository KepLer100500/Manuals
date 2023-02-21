package org.kepler;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Student {
    private String nameSurname;
    private int course;
    private double avgRate;
}
