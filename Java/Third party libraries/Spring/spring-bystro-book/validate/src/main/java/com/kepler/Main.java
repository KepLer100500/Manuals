package com.kepler;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Slf4j
public class Main {
    private static ConfigurableApplicationContext context;

    private static Device makeDevice(Integer id, String ipAddress) {
        // Create bean
        Device device = context.getBean("device", Device.class);
        device.setId(id);
        device.setIpAddress(ipAddress);
        // Validate bean
        ValidationService validator = context.getBean("validationService", ValidationService.class);
        try {
            validator.validDevice(device);
        } catch (ConstraintViolationException e) {
            log.error("{}", e.getMessage());
            return null;
        }
        return device;
    }

    private static List<Device> makeDevices(int count) {
        List<Device> devices = new ArrayList<>();
        Device device;

        for (int i = -count; i < count; i++) {
            // try to create negative beans
            device = makeDevice(i, "127.0.0.1");
            if (device != null) {
                devices.add(makeDevice(i, "127.0.0.1"));
            }
        }

        // try to create bad ip bean
        device = makeDevice(8, "500.500.500.500");
        if (device != null) {
            devices.add(makeDevice(8, "500.500.500.500"));
        }

        return devices;
    }

    public static void main(String[] args) {
        context = SpringApplication.run(Main.class, args);
        makeDevices(3).forEach(n -> log.info("{}", n));
    }
}
