package com.kepler;

import com.kepler.service.UserService;
import com.kepler.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class H2Application {
    private static void createDefaultValuesInDB(ConfigurableApplicationContext context) {
        var weatherService = context.getBean(WeatherService.class);
        var userService = context.getBean(UserService.class);

        weatherService.addDefaultWeathersToDB();
        userService.addDefaultUsersToDB();
        log.debug("Successfully created default values in DB.");
    }

    public static void main(String[] args) {
        var context = SpringApplication.run(H2Application.class, args);

        createDefaultValuesInDB(context); // Insert default values into DB h2
    }
}
