package com.it.employeeManagementThymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.employeeManagementThymeleaf.model.Employee;
import com.it.employeeManagementThymeleaf.repository.EmployeeRepository;

@Service
public class EmployeeService implements EmployeeServiceInterf {

	@Autowired
	EmployeeRepository employeeRepository;

//	get the employees
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public void saveEmployee(Employee emp) {
		employeeRepository.save(emp);
	}

	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> li = employeeRepository.findById(id);

		if (li.isPresent()) {
			Employee emp = li.get();
		} else {
			throw new RuntimeException("Employee not found:" + id);
		}
		return null;
	}

	@Override
	public void deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);

	}

}
