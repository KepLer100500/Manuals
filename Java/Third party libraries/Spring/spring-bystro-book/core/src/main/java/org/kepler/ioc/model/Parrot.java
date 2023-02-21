package org.kepler.ioc.model;

import lombok.*;
import org.springframework.stereotype.Component;
import javax.annotation.*;

@Data
@Component
public class Parrot {
    private String name;
    
    public Parrot() {
        System.out.println("Parrot created!");
    }

    @PostConstruct
    public void init() {
        this.setName("ololoshka!");
    }
}
