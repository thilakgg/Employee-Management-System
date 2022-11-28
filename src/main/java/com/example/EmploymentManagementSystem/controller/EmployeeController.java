package com.example.EmploymentManagementSystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmploymentManagementSystem.model.Employee;
import com.example.EmploymentManagementSystem.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		return service.addEmployee(employee);
	}
	
	@GetMapping("/getEmployee")
	public List<Employee> getEmployees(){
		return service.getEmployees();
	}
	
	@GetMapping("/getEmployee/{empId}")
	public Employee getEmployee(@PathVariable Long empId) {
		return service.getEmployee(empId);
	}

}
