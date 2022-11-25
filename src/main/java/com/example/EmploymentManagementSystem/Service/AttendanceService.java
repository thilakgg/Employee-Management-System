package com.example.EmploymentManagementSystem.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.EmploymentManagementSystem.Repository.AttendanceRepository;
import com.example.EmploymentManagementSystem.model.Attendance;

@Service
public class AttendanceService {
	
	@Autowired
	
	AttendanceRepository repository;
	
	public Attendance addAttendance( Attendance attendance) throws ParseException  {
		String date = attendance.getDate().toString();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		attendance.setDate(LocalDate.parse(date, formatter)); //setDateField
		
		String startTime= attendance.getStartTime().toString(); 
		attendance.setStartTime(LocalDateTime.parse(startTime));//setStartTimeField
		
		String endTime= attendance.getStartTime().toString();
		attendance.setEndTime(LocalDateTime.parse(startTime)); //setEndTimeField
		System.out.print(3);
		
		Long ot = caculateOT(attendance.getStartTime(), attendance.getEndTime());
		attendance.setOverTime(ot);   //setOverTimeField
		
		
		
		boolean p = ispresent(attendance.getStartTime(), attendance.getEndTime());
		attendance.setPresent(p);
		
		return repository.save(attendance);
		}
	
	//return the overtTime if is positive else null
	public Long caculateOT(LocalDateTime startTime, LocalDateTime endTime) {
		Long duration = (Long) Duration.between(startTime,endTime).toHours() ;
		if((duration - 8) <=0) {
			return null;
		}else {
			return duration;
		}}
		
	public boolean ispresent(LocalDateTime startTime, LocalDateTime endTime) {
		Long duration = Duration.between(startTime, endTime).toHours();
		if(duration >4) {
			return false;
		}else {
			return true;
		}
	
		
		
	
		
	}
	

}
