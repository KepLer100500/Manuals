package com.kepler.rest;

import com.kepler.model.Signal;
import com.kepler.service.SignalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/signal")
public class SignalController {
    @Autowired
    private SignalService signalService;

    @GetMapping("/{id}")
    public String showSignal(@PathVariable Integer id) {
        return signalService.getSignal(id).toString();
    }

    @PostMapping()
    public String generateSignal() {
        Signal signal = Signal.builder()
                .id(new Random().nextInt(10))
                .title(UUID.randomUUID().toString())
                .timestamp(LocalDateTime.now())
                .value(new Random().nextDouble(500))
                .build();

        signalService.createSignal(signal);

        return "Random signal generated: " + signal.toString();
    }
}
