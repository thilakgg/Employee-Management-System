package com.example.EmploymentManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmploymentManagementSystem.model.PaySlip;

@Repository
public interface PaySlipRepository extends JpaRepository<PaySlip, Long> {

	

}
