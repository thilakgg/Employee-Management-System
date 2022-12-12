package com.example.EmploymentManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmploymentManagementSystem.model.Salary;
import com.example.EmploymentManagementSystem.service.SalaryService;

@RestController
public class SalaryController {
	
	
	@Autowired
	SalaryService service;
	
	@PostMapping("/addSalary")
	public Salary addSalary(@RequestBody Salary salary) {
		return service.addSalary(salary);
	}
	
	
	@GetMapping("/salaryGreaterThan/{amt}")
	public List<Salary> getBasicSalaryGreaterThan(@PathVariable int amt){
		return service.getBasicSalaryGreaterThan(amt);
	}
	
	
	
	
	

}
