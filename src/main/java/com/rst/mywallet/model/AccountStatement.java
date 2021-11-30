package com.rst.mywallet.model;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class AccountStatement {

	public AccountStatement(BigDecimal currentBalance2, 
			List<Transaction> findByAccountNumber) {
	}
	
	private BigDecimal currentBalance;
	private List<Transaction> transactionHistory;
}
