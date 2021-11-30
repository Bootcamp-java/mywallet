package com.rst.mywallet.service;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.rst.mywallet.model.Account;
import com.rst.mywallet.model.AccountStatement;
import com.rst.mywallet.model.Transaction;
import com.rst.mywallet.model.TransferBalanceRequest;

@Service
@Component
@Configuration
public interface AccountService {
	
	List<Account> findAll();
	Account save(Account account);
	Transaction sendMoney(TransferBalanceRequest transferBalanceRequest);
	AccountStatement getStatement(String accountNumber);

}
