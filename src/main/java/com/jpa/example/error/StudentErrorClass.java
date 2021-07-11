package com.jpa.example.error;

public class StudentErrorClass {
	
	int statusCode;
	String errorMessage;
	long timeStamp;
	
	public StudentErrorClass() {
		
	}

	public StudentErrorClass(int statusCode, String errorMessage, int timeStamp) {
		super();
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
		this.timeStamp = timeStamp;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	

}
