package com.it.employeeManagementThymeleaf.service;

import java.util.List;

import com.it.employeeManagementThymeleaf.model.Employee;

public interface EmployeeServiceInterf {
	public List<Employee> getAllEmployees();
	
	public void saveEmployee(Employee emp) ;
	
	Employee getEmployeeById(int id);
	void deleteEmployeeById(int id);
}
