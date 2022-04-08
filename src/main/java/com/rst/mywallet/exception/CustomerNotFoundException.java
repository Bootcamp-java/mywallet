package com.rst.mywallet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerNotFoundException extends Exception{

	private long customerId;
	
	public CustomerNotFoundException(long customerId) {
		super(String.format("Customer is not found with id : '%s'", customerId));
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerNotFoundResponse> handleException(CustomerNotFoundResponse exc){
		
		CustomerNotFoundResponse error = new CustomerNotFoundResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage);
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
