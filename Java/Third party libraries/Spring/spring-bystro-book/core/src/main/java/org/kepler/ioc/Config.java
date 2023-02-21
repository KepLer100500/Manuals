package org.kepler.ioc;

import org.kepler.ioc.model.*;
import org.springframework.context.annotation.*;

@Configuration
public class Config {

    @Bean("my-parrot")
    Parrot parrot() {
        return new Parrot();
    }
    
}