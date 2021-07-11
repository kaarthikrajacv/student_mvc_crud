package com.jpa.example.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorClass> hanlesException(StudentNotFoundException e){
		
		System.out.println("Student Not found exception caught");
		StudentErrorClass err = new StudentErrorClass();
		
		err.setStatusCode(HttpStatus.NOT_FOUND.value());
		err.setErrorMessage(e.getMessage());
		err.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<StudentErrorClass>(err, HttpStatus.NOT_FOUND);
		
	}

	
	@ExceptionHandler
	public ResponseEntity<StudentErrorClass> hanlesException(Exception e){
		
		StudentErrorClass err = new StudentErrorClass();
		
		err.setStatusCode(HttpStatus.BAD_REQUEST.value());
		err.setErrorMessage(e.getMessage());
		err.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<StudentErrorClass>(err, HttpStatus.BAD_REQUEST);
		
	}
}
