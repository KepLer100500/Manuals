package com.kepler.rest;

import com.kepler.model.Weather;
import com.kepler.repo.WeatherRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/weather")
public class WeatherController {
    private final WeatherRepo weatherRepo;

    public WeatherController(WeatherRepo weatherRepo) {
        this.weatherRepo = weatherRepo;
    }

    @PreAuthorize("hasAuthority('developers:read')")
    @GetMapping("/{id}")
    public Weather getWeather(@PathVariable Long id) {
        log.debug("User request weather by ID: {}", id);
        return weatherRepo.findById(id).orElse(null);
    }
}
