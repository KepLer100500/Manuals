package com.kepler.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDateTime;

@RedisHash("signal")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Getter
@Setter
public class Signal implements Serializable {
    @Id
    private Integer id;

    private String title;
    private LocalDateTime timestamp;
    private Double value;
}
