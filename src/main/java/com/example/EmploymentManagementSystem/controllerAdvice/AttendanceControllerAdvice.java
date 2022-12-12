package com.example.EmploymentManagementSystem.controllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.EmploymentManagementSystem.exception.AttendanceException;

@RestControllerAdvice
public class AttendanceControllerAdvice {
	
	@ExceptionHandler(AttendanceException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public AttendanceException handleAttendanceException(AttendanceException exception){
		return exception.getMessage();
	}

}
