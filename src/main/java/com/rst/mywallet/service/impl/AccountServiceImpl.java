package com.rst.mywallet.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rst.mywallet.model.Account;
import com.rst.mywallet.model.AccountStatement;
import com.rst.mywallet.model.Transaction;
import com.rst.mywallet.model.TransferBalanceRequest;
import com.rst.mywallet.repository.AccountRepository;
import com.rst.mywallet.repository.TransactionRepository;
import com.rst.mywallet.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired(required=false)
	private AccountRepository accountRepository;

	@Autowired(required=false)
	private TransactionRepository transactionRepository;

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Account save(Account account) {
		accountRepository.save(account);

		return accountRepository.findByAccountNumber(account.getAccountNumber());
	}

	@Override
	public Transaction sendMoney(TransferBalanceRequest transferBalanceRequest) {
		String fromAccountNumber = transferBalanceRequest.getFromAccountNumber();
		String toAccountNumber = transferBalanceRequest.getToAccountNumber();
		BigDecimal amount = transferBalanceRequest.getAmount();

		Account fromAccount = accountRepository.findByAccountNumber(fromAccountNumber);

		Account toAccount = accountRepository.findByAccountNumber(toAccountNumber);

		if (fromAccount.getCurrentBalance().compareTo(BigDecimal.ONE) == 1
				&& fromAccount.getCurrentBalance().compareTo(amount) == 1) {

			fromAccount.setCurrentBalance(fromAccount.getCurrentBalance().subtract(amount));
			accountRepository.save(fromAccount);
			toAccount.setCurrentBalance(toAccount.getCurrentBalance().add(amount));
			accountRepository.save(toAccount);

			Transaction transaction = transactionRepository
					.save(new Transaction(0L, fromAccountNumber, amount, new Timestamp(System.currentTimeMillis())));
			return transaction;
		}
		return null;
	}

	@Override
	public AccountStatement getStatement(String accountNumber) {
		Account account =accountRepository.findByAccountNumber(accountNumber);
		return new AccountStatement(account.getCurrentBalance(),
				transactionRepository.findByAccountNumber(accountNumber));
	}

	public Account findByAccountNumber(String accountNumber) {
		Account account = accountRepository.findByAccountNumber(accountNumber);
		return account;
	}

}
