package com.kepler.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "temperature")
    private Double temperature;

    public static List<Weather> createDefaultValuesWeather() {
        return List.of(
                new Weather(1L, "Astrakhan", 30D),
                new Weather(2L, "Moscow", 20D),
                new Weather(3L, "Volgograd", 10D)
        );
    }

}
