package com.example.EmploymentManagementSystem.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.EmploymentManagementSystem.exception.AttendanceAlreadyExistsException;
import com.example.EmploymentManagementSystem.exception.AttendanceException;
import com.example.EmploymentManagementSystem.model.Attendance;
import com.example.EmploymentManagementSystem.model.Employee;
import com.example.EmploymentManagementSystem.repository.AttendanceRepository;

@Service
public class AttendanceService {

	@Autowired

	AttendanceRepository repository;

	@Autowired
	EmployeeService empService;

	public Attendance addAttendance(Attendance attendance, Long empId) throws AttendanceAlreadyExistsException {
		LocalDate date = attendance.getDate();
		Attendance attDate = repository.findByDate(date, empId);
		List<Attendance> getAtt =  getByEmpId(empId);
		if ((!getAtt.isEmpty()) && (attDate  != null)) {
			throw new AttendanceAlreadyExistsException("Attendance for " + date + " already exists");
		} else {
			attendance.getDate();
			LocalDateTime getStartTime = attendance.getStartTime();
			LocalDateTime getEndTime = attendance.getEndTime();
			Employee emp = empService.getEmployee(empId);
			attendance.setStartTime(getStartTime);
			attendance.setEndTime(getEndTime);
			attendance.setEmployee(emp);
			Long ot = calculateOt(getStartTime, getEndTime);
			attendance.setOverTime(ot);
			Attendance result = repository.save(attendance);
			return result;
		
	
		}
		

	}

	// return the overtTime if is positive else null
	public Long calculateOt(LocalDateTime startTime, LocalDateTime endTime) {
		Long ot = (Long) Duration.between(startTime, endTime).toHours() - Long.valueOf(8);
		if (ot >= 0) {
			return ot;
		}
		return null;

	}

//		  
	public List<Attendance> getAttendance(Long empId) {
		return repository.findByEmployeeId(empId);

	}

	public Attendance getByDate(LocalDate date, Long empId) {
		if( repository.findByDate(date, empId) == null) {
			throw new AttendanceException("No Attendance record exists for employeeid  " + empId +
					" for the date " + date );
		}else {
			return repository.findByDate(date, empId);
		}
	}
	
	public List<Attendance> getByEmpId(Long empId) {
		return  repository.findByEmployeeId(empId);
	}

}
