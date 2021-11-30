package com.rst.mywallet.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.rst.mywallet.dto.CustomerDTO;
import com.rst.mywallet.model.Customer;
import com.rst.mywallet.repository.CustomerRepository;
import com.rst.mywallet.service.CustomerService;

import lombok.CustomLog;

public class CustomerServiceImpl implements CustomerService{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired(required=false)
	CustomerRepository custRepo;
	
	@Override
	public Customer createCustomer(CustomerDTO custDTO) {
		logger.info("Creation request for customer {}", custDTO);
		Customer cust = custDTO.createEntity();
		return custRepo.save(cust);
	}
	
	@Override
	public CustomerDTO getCustomerProfile(Long phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	} 

}
