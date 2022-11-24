package com.example.EmploymentManagementSystem.Model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

//this class as unidirectional OnetoMany mapping with Employee table

@Entity
@Table(name = "attendance")
@Component
public class Attendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date;
	private Date startTime;
	private Date endTime;
	private boolean present = true;
	private Integer overTime =  null;
	
	public Attendance(Date date, Date startTime, Date endTime) {
		super();
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public Date getDate() {
		return date;
	}
	
	public Attendance() {
		
	}
	
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isPresent() {
		return present;
	}
	public void setPresent(boolean present) {
		this.present = present;
	}
	public Integer getOverTime() {
		return overTime;
	}
	public void setOverTime(Integer overTime) {
		this.overTime = overTime;
	}
	
	
	
	
	
	
	

}
