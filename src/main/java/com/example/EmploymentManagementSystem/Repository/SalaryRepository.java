package com.example.EmploymentManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmploymentManagementSystem.Model.Salary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Integer> {

}
