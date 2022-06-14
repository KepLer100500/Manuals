package org.kepler.rest.dao;

import org.kepler.rest.model.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.*;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
        Query query = entityManager.createQuery("from Employee");
        List<Employee> allEmployees = query.getResultList();
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }

}