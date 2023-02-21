package org.kepler.di.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class PersonAutowiredSetter {
    private String name;
    private Parrot parrot;
    
    @Autowired
    void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }
}
