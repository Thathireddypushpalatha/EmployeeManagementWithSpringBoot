package com.it.employeeManagementThymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.it.employeeManagementThymeleaf.model.Employee;
import com.it.employeeManagementThymeleaf.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

//	list of the employees
	@GetMapping("/getAll")
	public String viewHome(Model model) {
		model.addAttribute("listEmployees",employeeService.getAllEmployees());
		return "index";
	}
	
	@GetMapping("/showEmployeeForm")
	public String showEmployeeForm() {
		return "newEmployee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee emp) {
		employeeService.saveEmployee(emp);
		return "redirect:/getAll";
		
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable("id") int id,Model model) {
		Employee emp=employeeService.getEmployeeById(id);
		model.addAttribute("employee",emp);
		return "newEmployee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") int id,Model model) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/getAll";
		
	}

}
