package org.kepler;

import org.kepler.configuration.Config;
import org.kepler.model.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;


public class App {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Communication communication = context.getBean("communication", Communication.class);
        // add new employee
        Employee newEmployee = Employee.builder()
                .name("Test name")
                .surname("Test surname")
                .department("Test department")
                .salary(500)
                .build();
        communication.saveEmployee(newEmployee);
        // get employee by id
        Employee employee = communication.getEmployee(2);
        System.out.println("Employee: " + employee);
        // change salary for employee (if he in DB!!!)
        try {
            employee.setSalary(10000);
            communication.saveEmployee(employee);
        } catch (Exception e) {
            System.out.println("Fail try to change employee! Employee not found!");
        }
        // delete employee by id
        communication.deleteEmployee(2);
        // show all employees
        List<Employee> employees = communication.getAllEmployees();
        System.out.println(employees);
    }
}
