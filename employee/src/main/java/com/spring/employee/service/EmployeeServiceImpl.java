package com.spring.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.employee.model.Employee;
import com.spring.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	 private EmployeeRepository employeeRepository;
	
	//Save
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	//Read	
	public List<Employee> FetchEmployeeDetails(){
		return (List<Employee>)employeeRepository.findAll();
	}
	
	//Update
	public Employee updateEmployeeById(Employee employee, Long id) {
		 Employee emp = employeeRepository.findById(id).get();
		 
		 emp.setName(employee.getName());
		 
		 emp.setSalary(employee.getSalary());
		 
		 return employeeRepository.save(emp);
	}
	
	//Delete
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
	}
}
