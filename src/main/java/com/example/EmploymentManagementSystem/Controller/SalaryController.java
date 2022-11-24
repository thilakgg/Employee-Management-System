package com.example.EmploymentManagementSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmploymentManagementSystem.Model.Salary;
import com.example.EmploymentManagementSystem.Service.SalaryService;

@RestController
public class SalaryController {
	
	
	@Autowired
	SalaryService service;
	
	@PostMapping("/addSalary")
	public Salary addSalary(@RequestBody Salary salary) {
		return service.addSalary(salary);
	}
	
	
	
	
	
	

}
