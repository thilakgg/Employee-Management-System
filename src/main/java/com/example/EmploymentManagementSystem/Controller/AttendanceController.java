package com.example.EmploymentManagementSystem.Controller;

import java.text.ParseException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmploymentManagementSystem.Service.AttendanceService;
import com.example.EmploymentManagementSystem.model.Attendance;

@RestController
public class AttendanceController {
	
	@Autowired
	AttendanceService service;
	
	
	@PostMapping("/addAttendance")
	public Attendance addAttendance(@RequestBody Attendance attendance) throws ParseException {
		return service.addAttendance(attendance);
	}

}
