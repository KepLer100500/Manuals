package org.kepler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.kepler.model.Employee;
import org.kepler.service.EmployeeService;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class MainController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/")
	public String indexView(Model model) {
		List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);
		return "index";
	}

	@RequestMapping("/addNewEmployee")
	public String addNewEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employee-info";
	}

	@RequestMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}

	@RequestMapping("/updateInfo")
	public String editEmployee(@RequestParam("empId") int id, Model model) {
		Employee employee = employeeService.getEmployee(id);
		model.addAttribute("employee", employee);
		return "employee-info";
	}

	@RequestMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("empId") int id) {
		employeeService.deleteEmployee(id);
		return "redirect:/";
	}

}
