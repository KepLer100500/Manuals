package com.kepler.rest;

import com.kepler.model.Developer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperController {
    List<Developer> DEVELOPERS = Developer.makeDefaultDeveloperList();

    @GetMapping
    @PreAuthorize("hasAuthority('developers:read')")
    public List<Developer> getDevelopers() {
        return DEVELOPERS;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:read')")
    public Developer getDeveloper(@PathVariable Long id) {
        return DEVELOPERS.stream()
                .filter(developer -> developer.getId().equals(id)).findFirst()
                .orElse(null);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('developers:write')")
    public ResponseEntity<Developer> addDeveloper(@RequestBody Developer developer) {
        DEVELOPERS.add(developer);
        return ResponseEntity.status(HttpStatus.OK).body(developer); // HTTP/1.1 200
    }

    @DeleteMapping("/{id}")
    public void removeDeveloper(@PathVariable Long id) {
        DEVELOPERS.removeIf(developer -> developer.getId().equals(id));
    }

}
