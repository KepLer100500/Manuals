package org.kepler.rest.service;

import org.kepler.rest.model.Employee;
import java.util.List;


public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);

    List<Employee> findAllByName(String name);
}