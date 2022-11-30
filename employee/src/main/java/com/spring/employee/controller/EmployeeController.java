package com.spring.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.employee.model.Employee;
import com.spring.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired(required = true)
	private EmployeeService employeeService;
	
	@PostMapping("/emp")
	@ResponseStatus(HttpStatus.CREATED) //201
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@GetMapping("/emp")
	@ResponseStatus(HttpStatus.OK) //200
	public List<Employee> FetchEmployeeDtails() {
		return employeeService.FetchEmployeeDetails();
	}
	
	@PutMapping("/emp/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED) //202
	public Employee updateEmployeeById(@RequestBody Employee employee, @PathVariable("id") Long id) {
		return employeeService.updateEmployeeById(employee, id);
	}
	
	@DeleteMapping("/emp/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED) //202
	public String deleteEmployeeById(@PathVariable("id") Long id) {
		employeeService.deleteEmployeeById(id);
		return "Deleted Succesfully";
	}

}
