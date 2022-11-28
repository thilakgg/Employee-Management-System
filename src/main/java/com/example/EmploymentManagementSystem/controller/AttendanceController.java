package com.example.EmploymentManagementSystem.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmploymentManagementSystem.model.Attendance;
import com.example.EmploymentManagementSystem.model.Employee;
import com.example.EmploymentManagementSystem.service.AttendanceService;
import com.example.EmploymentManagementSystem.service.EmployeeService;

@RestController
public class AttendanceController {

	@Autowired
	AttendanceService service;
	EmployeeService employeeService;
	
	@PostMapping("/{empId}/addAttendance")
	public Attendance addAttendance(@PathVariable Long empId, @RequestBody Attendance attendance) throws ParseException {
		
		
		
		return service.addAttendance(attendance);
	}
	

}
