package com.jpa.example.error;

public class StudentNotFoundException extends RuntimeException {
	
	public StudentNotFoundException(String message) {
		
		super(message);
	}

}
