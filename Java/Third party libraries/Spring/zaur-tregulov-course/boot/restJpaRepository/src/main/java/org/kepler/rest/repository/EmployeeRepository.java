package org.kepler.rest.repository;

import org.kepler.rest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> { // class, id type
    public List<Employee> findAllByName(String name);
}
