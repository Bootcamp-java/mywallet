package com.rst.mywallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rst.mywallet.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByCustomerId(final long customerId);
	
	Customer findByEmail(final String email);
	     
}
