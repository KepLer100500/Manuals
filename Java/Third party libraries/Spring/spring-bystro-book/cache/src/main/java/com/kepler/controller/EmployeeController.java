package com.kepler.controller;

import com.kepler.model.Employee;
import com.kepler.service.HighLoadService;
import org.springframework.web.bind.annotation.*;


@RestController
public class EmployeeController {

    private final HighLoadService highLoadService;

    public EmployeeController(HighLoadService highLoadService) {
        this.highLoadService = highLoadService;
    }

    /**
     * curl -X GET http://localhost:8081/1 -d '{name: KepLer}' -H "Content-Type: application/json"
     * @param recordId int
     * @param name String
     * @return Employee
     */
    @GetMapping("/{recordId}")
    public Employee createOrGetEmployee(@PathVariable("recordId") int recordId, @RequestBody String name) {
        return highLoadService.createOrGetEmployee(recordId, name);
    }

    /**
     * curl -X PUT http://localhost:8081/1 -d '{name: KepLer}' -H "Content-Type: application/json"
     * @param recordId int
     * @param name String
     * @return Employee
     */
    @PutMapping("/{recordId}")
    public Employee updateEmployee(@PathVariable("recordId") int recordId, @RequestBody String name) {
        return highLoadService.updateEmployee(recordId, name);
    }

    /**
     * curl -X DELETE http://localhost:8081/1
     * @param recordId int
     * @return Ok status
     */
    @DeleteMapping("/{recordId}")
    public String removeEmployee(@PathVariable("recordId") int recordId) {
        highLoadService.removeEmployee(recordId);
        return "Employee success removed";
    }
}
