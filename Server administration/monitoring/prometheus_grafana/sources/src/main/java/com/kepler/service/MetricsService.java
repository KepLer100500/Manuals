package com.kepler.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class MetricsService {
    private final Counter customCounter;

    public MetricsService(MeterRegistry registry) {
        this.customCounter = Counter.builder("kepler_custom_metric")
                .description("KepLer custom counter description")
                .register(registry);
    }

    public Counter getCounter() {
        return customCounter;
    }

    public void incrementCustomMetric() {
        customCounter.increment();
    }
}
