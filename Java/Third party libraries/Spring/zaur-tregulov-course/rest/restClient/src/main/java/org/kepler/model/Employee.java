package org.kepler.model;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class Employee {
    private int id;
    private String name;
    private String surname;
    private String department;
    private int salary;
}
