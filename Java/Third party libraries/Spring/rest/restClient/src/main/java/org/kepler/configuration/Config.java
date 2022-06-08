package org.kepler.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
@ComponentScan("org.kepler")
public class Config {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
