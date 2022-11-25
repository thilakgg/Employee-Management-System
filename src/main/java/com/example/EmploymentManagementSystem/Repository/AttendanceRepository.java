package com.example.EmploymentManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmploymentManagementSystem.model.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long>{

}
