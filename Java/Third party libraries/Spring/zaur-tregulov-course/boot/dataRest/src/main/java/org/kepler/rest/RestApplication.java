package org.kepler.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* *
GET:
http://localhost:8080/employees/   - get all employees
http://localhost:8080/employees/7  - get employee by id
POST:
http://localhost:8080/employees/   - create new employee
PUT:
http://localhost:8080/employees/17 - edit employee
DELETE:
http://localhost:8080/employees/17 - remove employee

http://localhost:8080/actuator/health   - show UP or DOWN status app
http://localhost:8080/actuator/info     - show description for app
http://localhost:8080/actuator/beans    - show all registered beans
http://localhost:8080/actuator/env      - show system variables
http://localhost:8080/actuator/mappings - show url mappings

Adding basic security - login/pass = admin
*/

@SpringBootApplication
public class RestApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}
}
