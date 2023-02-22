package com.kepler.repo;

import com.kepler.model.Weather;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepo extends CrudRepository<Weather, Long> {
}
