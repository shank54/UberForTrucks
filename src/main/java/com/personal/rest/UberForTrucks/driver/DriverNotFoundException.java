package com.personal.rest.UberForTrucks.driver;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DriverNotFoundException extends RuntimeException {

	public DriverNotFoundException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
}
