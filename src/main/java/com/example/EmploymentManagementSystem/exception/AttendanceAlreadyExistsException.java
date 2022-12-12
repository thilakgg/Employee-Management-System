package com.example.EmploymentManagementSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class AttendanceAlreadyExistsException extends RuntimeException{
	
		
	public AttendanceAlreadyExistsException() {
		
	}

	public AttendanceAlreadyExistsException(String message) {
		super(message);
	}
	
	
	
	

}
