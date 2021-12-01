package com.rst.mywallet.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rst.mywallet.dto.Response;
import com.rst.mywallet.model.Account;
import com.rst.mywallet.model.AccountStatementRequest;
import com.rst.mywallet.model.TransferBalanceRequest;
import com.rst.mywallet.service.AccountService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AccountController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public AccountService accountService;

	@PostMapping(value = "/create" , produces = MediaType.APPLICATION_JSON_VALUE )
	public List<Account> create(@RequestBody Account account) {
		accountService.save(account);
		return accountService.findAll();
	}

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Account> all(@PathVariable String accountNumber) {
		
		logger.info("Account Number {}", accountNumber);
		return accountService.findAll();
	}

	@PostMapping(value ="/sendmoney" , produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<?> sendMoney(@RequestBody TransferBalanceRequest transferBalanceRequest) {
		return Response.ok().setPayload(accountService.sendMoney(transferBalanceRequest));
	}

	
	@GetMapping(value = "/getStatement", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<?> getStatement(@RequestBody AccountStatementRequest accountStatementRequest) {

		return Response.ok().setPayload(accountService.getStatement(accountStatementRequest.getAccountNumber()));
	}
}
