package com.example.EmploymentManagementSystem.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "employee")

public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private boolean active;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="salary_id")
	public Salary salary;
//	@OneToMany(cascade=CascadeType.ALL)
//	//@JoinTable() 
//    public List<Attendance> attendance;

//	public Salary getSalary() {
//		return salary;
//	}


	public Employee() {
		
	}
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Salary getSalary() {
		return salary;
	}



	public void setSalary(Salary salary) {
		this.salary = salary;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

}
