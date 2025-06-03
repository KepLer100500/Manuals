package com.kepler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
    @GetMapping("/status")
    public String getStatus() {
        return "status: ok";
    }
}
