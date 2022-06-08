package org.kepler.controller;

import org.springframework.web.bind.annotation.*;
import org.kepler.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.kepler.model.Employee;
import java.util.List;
import org.kepler.exception.*;


@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if(employee == null) {
            throw new NoSuchEmployeeException("Not found employee with id: " + id);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if(employee == null) {
            throw new NoSuchEmployeeException("Not found employee with id: " + id);
        }
        employeeService.deleteEmployee(id);
        return "Record id: " + id + " is deleted!";
    }

}