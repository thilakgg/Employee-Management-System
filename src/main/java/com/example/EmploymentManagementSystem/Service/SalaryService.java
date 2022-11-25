package com.example.EmploymentManagementSystem.Service;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.EmploymentManagementSystem.Repository.SalaryRepository;
import com.example.EmploymentManagementSystem.model.PaySlip;
import com.example.EmploymentManagementSystem.model.Salary;

@Service
public class SalaryService {
	
	@Autowired
	SalaryRepository repository;
	
	public Salary addSalary(Salary salary) {
		Month month = LocalDate.now().getMonth();
		salary.setMonth(month);
		return repository.save(salary);
				
	}
	
	//get salary by employee id
	public void getSalary(@PathVariable int empID) {}
	
	//method process payment depending on the Status of the employee in company
	public void ProcessPayment() {}
	
	//method to calculate deductions
	public void calculateDecuctions() {}
	
	public void calculateAllowance() {
		
	}
	
	//create pdf of payslip
	
	public void createPaySlip(PaySlip payslip) {
		
	}
	
	

}
