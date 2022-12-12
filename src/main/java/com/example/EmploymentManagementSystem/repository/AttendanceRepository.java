package com.example.EmploymentManagementSystem.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.EmploymentManagementSystem.model.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long>{
	
//	Attendance findfirstByOrderByDateDesc();
	
	List<Attendance> findByEmployeeId(Long empId);
	
	@Query("SELECT a FROM Attendance a WHERE a.date = ?1 GROUP BY a.employee.id HAVING a.employee.id = ?2")
	Attendance findByDate(LocalDate date, Long empid);

}
