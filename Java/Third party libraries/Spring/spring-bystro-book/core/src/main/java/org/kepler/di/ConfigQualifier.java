package org.kepler.di;

import org.kepler.di.model.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigQualifier {
    
    @Bean
    Parrot parrot1() {
        Parrot parrot = new Parrot();
        parrot.setName("Lemon");
        return parrot;
    }
    
    @Bean
    Parrot parrot2() {
        Parrot parrot = new Parrot();
        parrot.setName("Twinkie");
        return parrot;
    }
    
    @Bean
    Person person(@Qualifier("parrot2") Parrot parrot) {
        Person person = new Person();
        person.setName("Papich");
        person.setParrot(parrot);
        return person;
    }
}
