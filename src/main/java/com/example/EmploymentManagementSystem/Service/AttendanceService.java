package com.example.EmploymentManagementSystem.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.EmploymentManagementSystem.Model.Attendance;
import com.example.EmploymentManagementSystem.Repository.AttendanceRepository;

@Service
public class AttendanceService {
	
	@Autowired
	AttendanceRepository repository;
	
	public Attendance addAttendance( Attendance attendance) throws ParseException  {
		Date date = new SimpleDateFormat("MM-dd-yyyy").parse(attendance.getDate().toString());
		attendance.setDate(date);
		Date startTime = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss").parse(attendance.getStartTime().toString());
		attendance.setStartTime(startTime);
		Date endTime = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss").parse(attendance.getEndTime().toString());

		attendance.setEndTime(endTime);
		return repository.save(attendance);
		
		

	
	}

}
