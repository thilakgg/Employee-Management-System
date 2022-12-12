package com.example.EmploymentManagementSystem.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.EmploymentManagementSystem.model.Employee;
import com.example.EmploymentManagementSystem.model.PaySlip;
import com.example.EmploymentManagementSystem.model.Salary;
import com.example.EmploymentManagementSystem.repository.EmployeeRepository;
import com.example.EmploymentManagementSystem.repository.SalaryRepository;

@Service
public class SalaryService {

	@Autowired
	SalaryRepository repository;
	@Autowired
	AttendanceService attservice;
//	EmployeeService employeeService;
//	EmployeeRepository employeeRepository;
//	PaySlip paySlip;

	public Salary addSalary(Salary salary) {
		salary.getMonth();
		return repository.save(salary);

	}

	public List<Salary> getBasicSalaryGreaterThan(int amt)  {
		
		return repository.findByBasicSalaryGreaterThan(amt);
	}
	


}
