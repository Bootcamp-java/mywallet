package com.rst.mywallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rst.mywallet.model.Account;
import com.rst.mywallet.model.Customer;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	
	Account findByAccountNumber(String accountNumber);
}
