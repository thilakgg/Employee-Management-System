package com.example.EmploymentManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EmploymentManagementSystem.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{


}
