package com.kepler.rest;

import com.kepler.model.Developer;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperController {
    List<Developer> DEVELOPERS = Developer.makeDefaultDeveloperList();

    @GetMapping
    public List<Developer> getDevelopers() {
        return DEVELOPERS;
    }

    @GetMapping("/{id}")
    public Developer getDeveloper(@PathVariable Long id) {
        return DEVELOPERS.stream()
                .filter(developer -> developer.getId().equals(id)).findFirst()
                .orElse(null);
    }

    @PostMapping
    public Developer addDeveloper(@RequestBody Developer developer) {
        DEVELOPERS.add(developer);
        return developer;
    }

    @DeleteMapping("/{id}")
    public void removeDeveloper(@PathVariable Long id) {
        DEVELOPERS.removeIf(developer -> developer.getId().equals(id));
    }

}
