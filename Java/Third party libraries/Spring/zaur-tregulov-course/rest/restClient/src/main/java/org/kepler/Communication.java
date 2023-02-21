package org.kepler;

import org.kepler.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import java.util.List;


@Component
public class Communication {
    @Autowired
    RestTemplate restTemplate;

    private final String URL = "http://localhost:8080/api/employees";

    public List<Employee> getAllEmployees() {
        ResponseEntity<List<Employee>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Employee>>() {});
        List<Employee> employees = responseEntity.getBody();
        return employees;
    }

    public Employee getEmployee(int id) {
        Employee employee = null;
        try {
            employee = restTemplate.getForObject(URL + "/" + id, Employee.class);
        } catch (HttpClientErrorException e) {
            System.out.println("Fail try to get employee! Employee not found!");
        }
        return employee;
    }

    public void saveEmployee(Employee employee) {
        int id = employee.getId();
        if(id == 0) {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, employee, String.class);
            System.out.println("Add new employee: " + employee);
            System.out.println(responseEntity.getBody());
        } else {
            restTemplate.put(URL, employee);
            System.out.println("Employee: " + employee + ". Was changed.");
        }
    }

    public void deleteEmployee(int id) {
        try {
            restTemplate.delete(URL + "/" + id);
            System.out.println("Employee: " + id + " was deleted");
        } catch (HttpClientErrorException e) {
            System.out.println("Fail try to delete! Employee not found!");
        }
    }
}
