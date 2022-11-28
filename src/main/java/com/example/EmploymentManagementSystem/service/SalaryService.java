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
	EmployeeService employeeService;
	EmployeeRepository employeeRepository;
	PaySlip paySlip;
	
	public Salary addSalary(Salary salary) {
		Month month = LocalDate.now().getMonth();
		salary.setMonth(month);
		return repository.save(salary);
				
	}
	
	//get salary by employee id
	public void getSalary(@PathVariable int empID) {}
	
	//method process payment depending on the Status of the employee in company
	
	
	
	//method to calculate deductions
	public void calculateDecuctions() {}
	
	public void calculateAllowance() {
		
	}
	
	//create pdf of payslip
	
	public void createPaySlip(PaySlip payslip) {
		
	}
	
	

}
