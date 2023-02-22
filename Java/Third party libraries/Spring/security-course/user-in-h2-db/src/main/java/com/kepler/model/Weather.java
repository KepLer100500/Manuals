package com.kepler.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "weather")
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "temperature")
    private Double temperature;

    private static double createRandomTemperature() {
        double MAX_RAND = 30.0;
        double MIN_RAND = -30.0;
        return Math.random() * (MAX_RAND - MIN_RAND) + MIN_RAND;
    }
    public static List<Weather> createDefaultValuesWeather() {
        List<String> cities = List.of(
                "Astrakhan", "Dakar", "Jakarta", "Casablanca", "Madrid",
                "Munich", "New York", "Rotterdam", "Moscow", "Philadelphia"
        );
        return cities.stream()
                .map(city -> new Weather(0L, city, createRandomTemperature()))
                .collect(Collectors.toList());
    }
}
