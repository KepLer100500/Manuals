package org.kepler.di.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Data
@Component
public class PersonQualifierConstructor {
    private String name;
    private Parrot parrot;
    
    public PersonQualifierConstructor(@Qualifier("parrot") Parrot parrot) {
        this.parrot = parrot;
    }
}
