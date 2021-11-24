package com.rst.mywallet.exception;

public class CustomerNotFoundException extends Exception{

	private long customerId;
	
	public CustomerNotFoundException(long customerId) {
		super(String.format("Customer is not found with id : '%s'", customerId));
	}
}
