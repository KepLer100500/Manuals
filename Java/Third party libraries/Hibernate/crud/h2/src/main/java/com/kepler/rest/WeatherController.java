package com.kepler.rest;

import com.kepler.model.Weather;
import com.kepler.repo.WeatherRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/weather")
public class WeatherController {
    private final WeatherRepo weatherRepo;

    public WeatherController(WeatherRepo weatherRepo) {
        this.weatherRepo = weatherRepo;
        this.addDefaultWeatherToDB();
    }

    private void addDefaultWeatherToDB() {
        weatherRepo.saveAll(Weather.createDefaultValuesWeather());
    }

    @GetMapping("/{id}")
    public Weather getWeather(@PathVariable Long id) {
        return weatherRepo.findById(id).orElse(null);
    }
}
