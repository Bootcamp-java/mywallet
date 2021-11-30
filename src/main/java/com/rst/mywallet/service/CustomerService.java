package com.rst.mywallet.service;

import org.springframework.stereotype.Service;

import com.rst.mywallet.dto.CustomerDTO;
import com.rst.mywallet.model.Customer;

public interface CustomerService {

	
	public Customer createCustomer(CustomerDTO custDTO) ;
	
	public CustomerDTO getCustomerProfile(Long phoneNumber);
}
