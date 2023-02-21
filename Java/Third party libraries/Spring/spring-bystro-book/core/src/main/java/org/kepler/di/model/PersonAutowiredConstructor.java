package org.kepler.di.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class PersonAutowiredConstructor {
    private String name;
    private final Parrot parrot;
    
    @Autowired
    public PersonAutowiredConstructor(Parrot parrot) {
        this.parrot = parrot;
    }
}
