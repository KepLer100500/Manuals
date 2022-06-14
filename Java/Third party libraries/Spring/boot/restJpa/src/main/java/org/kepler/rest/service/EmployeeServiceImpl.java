package org.kepler.rest.service;

import org.kepler.rest.model.Employee;
import java.util.List;
import org.kepler.rest.dao.EmployeeDAO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}