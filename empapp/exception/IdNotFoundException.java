package com.employeeapplication.empapp.exception;

public class IdNotFoundException extends RuntimeException {

	private String message;


	public IdNotFoundException(String message) {
		super();
        this.message = message;
	}



}
