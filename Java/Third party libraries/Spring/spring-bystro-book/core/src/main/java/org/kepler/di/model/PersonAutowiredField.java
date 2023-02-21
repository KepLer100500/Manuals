package org.kepler.di.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class PersonAutowiredField {
    private String name;
    @Autowired
    private Parrot parrot;
}
