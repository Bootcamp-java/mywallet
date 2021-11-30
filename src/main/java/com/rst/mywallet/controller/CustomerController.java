package com.rst.mywallet.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rst.mywallet.model.Customer;
import com.rst.mywallet.repository.CustomerRepository;
import com.rst.mywallet.service.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired(required=false)
	private CustomerService custService;
	
	@Autowired(required=false)
	private CustomerRepository custRepository;
	
	@PostMapping(value = "/customers", consumes =  MediaType.APPLICATION_JSON_VALUE)
	public Customer createCustomer(@RequestBody Customer cust) {
		logger.info("Customer created{}",cust);
		return custRepository.save(cust);
	}
	
	
}
