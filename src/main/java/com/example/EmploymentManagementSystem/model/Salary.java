package com.example.EmploymentManagementSystem.model;

import java.time.LocalDate;
import java.time.Month;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

//this table as bidirectional OneToOne relationship with employee table

@Entity
@Table(name ="salary")
public class Salary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Month month;
	
	private Integer basicSalary;
	
	private Long ctc;
	private Integer grossSalary;
	

	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name ="id", referencedColumnName= "id")
//	private Employee employee;
	
	
	
	
	//private Employee employee;
	
	
	public Salary() {
		
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Month getMonth() {
		return month;
	}
	public void setMonth(Month month) {
		this.month = month;
	}
	public Integer getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(Integer basicSalary) {
		this.basicSalary = basicSalary;
	}
	public Long getCtc() {
		return ctc;
	}
	public void setCtc(Long ctc) {
		this.ctc = ctc;
	}
	public Integer getGrossSalary() {
		return grossSalary;
	}
	public void setGrossSalary(Integer grossSalary) {
		this.grossSalary = grossSalary;
	}

	




	
	

}
