package com.spring.employee.service;

import java.util.List;

import com.spring.employee.model.Employee;

public interface EmployeeService {
		
		//Save
		Employee saveEmployee(Employee employee);
		
		//Read
		List<Employee> FetchEmployeeDetails();
		
		//Update
		Employee updateEmployeeById(Employee employee, Long id);
		
		//Delete	
		void deleteEmployeeById(Long id);


}
