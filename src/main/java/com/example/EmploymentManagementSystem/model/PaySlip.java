package com.example.EmploymentManagementSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;


@Entity(name = "payslip")
@Component
public class PaySlip {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name ="basic_salary")
	private int basicSalary;
	@Column(name ="house_rentallowance")
	private int houseRentallowance;
	@Column(name ="dearness_allowance")
	private int dearnessAllowance;
	@Override
	public String toString() {
		return "PaySlip [id=" + id + ", basicSalary=" + basicSalary + ", houseRentallowance=" + houseRentallowance
				+ ", dearnessAllowance=" + dearnessAllowance + ", providentFund=" + providentFund + ", professionalTax="
				+ professionalTax + ", grossSalary=" + grossSalary + ", employeeId=" + employeeId + "]";
	}

	@Column(name ="provident_fund")
	private int providentFund;
	@Column(name ="professional_tax")
	private int professionalTax ;
	@Column(name ="gross_salary")
	private int grossSalary;
	@Column(name = "employee_id")
	private Long employeeId;
	
	public PaySlip() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(int basicSalary) {
		this.basicSalary = basicSalary;
	}

	public int getHouseRentallowance() {
		return houseRentallowance;
	}

	public void setHouseRentallowance(int houseRentallowance) {
		this.houseRentallowance = houseRentallowance;
	}

	public int getDearnessAllowance() {
		return dearnessAllowance;
	}

	public void setDearnessAllowance(int dearnessAllowance) {
		this.dearnessAllowance = dearnessAllowance;
	}

	public int getProvidentFund() {
		return providentFund;
	}

	public void setProvidentFund(int providentFund) {
		this.providentFund = providentFund;
	}

	public int getProfessionalTax() {
		return professionalTax;
	}

	public void setProfessionalTax(int professionalTax) {
		this.professionalTax = professionalTax;
	}

	public int getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(int grossSalary) {
		this.grossSalary = grossSalary;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	
	
	
	

}
