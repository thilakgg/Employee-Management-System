package com.example.EmploymentManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmploymentManagementSystem.model.Salary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Integer> {
	
	List<Salary> findByBasicSalaryGreaterThan(Integer salary);

	

}
