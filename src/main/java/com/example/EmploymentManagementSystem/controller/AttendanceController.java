package com.example.EmploymentManagementSystem.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmploymentManagementSystem.exception.AttendanceAlreadyExistsException;
import com.example.EmploymentManagementSystem.exception.AttendanceException;
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
	public ResponseEntity addAttendance(@PathVariable Long empId, @RequestBody Attendance attendance) throws AttendanceAlreadyExistsException {
		try {
			Attendance saveAttendance = service.addAttendance(attendance, empId);
			return new ResponseEntity<>(saveAttendance, HttpStatus.CREATED);
		} catch (AttendanceAlreadyExistsException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}

	@GetMapping("/{empId}/getAttendance")
	public List<Attendance> getAttendance(@PathVariable Long empId) {
		return service.getAttendance(empId);
	}

	@GetMapping("/getAttendanceByDate")
	public  Attendance getByDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestParam Long empId) {
		
		return  service.getByDate(date, empId);
	}
	
	//using spring capability to handle exceptions
	
	

}
