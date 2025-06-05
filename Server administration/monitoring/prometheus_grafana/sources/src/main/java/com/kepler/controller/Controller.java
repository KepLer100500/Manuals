package com.kepler.controller;

import com.kepler.service.MetricsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class Controller {

    private final MetricsService metricsService;

    public Controller(MetricsService metricsService) {
        this.metricsService = metricsService;
    }

    @GetMapping
    public double getCounter() {
        return metricsService.getCounter().count();
    }

    @PostMapping
    public void addCounter() {
        metricsService.incrementCustomMetric();
    }
}
