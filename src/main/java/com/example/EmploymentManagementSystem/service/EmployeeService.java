package com.example.EmploymentManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmploymentManagementSystem.model.Employee;
import com.example.EmploymentManagementSystem.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repository;
	
	public Employee addEmployee(Employee employee) {
		return repository.save(employee);
	}
	
	public List<Employee> getEmployees( ){
		return repository.findAll();
	}
	
	public Employee getEmployee(Long empId) {
		return repository.findById(empId).orElseThrow();
	}

}
