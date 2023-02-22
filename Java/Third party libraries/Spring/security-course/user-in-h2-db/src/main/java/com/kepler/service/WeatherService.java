package com.kepler.service;

import com.kepler.model.Weather;
import com.kepler.repo.WeatherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class WeatherService {
    @Autowired
    WeatherRepo weatherRepo;

    @Transactional
    public void addDefaultWeathersToDB() {
        weatherRepo.saveAll(Weather.createDefaultValuesWeather());
    }
}
