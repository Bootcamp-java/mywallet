package com.rst.mywallet.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "transaction")
@Data
public class Transaction {

	public Transaction(long l, String fromAccountNumber, BigDecimal amount, Timestamp timestamp) {
	}

	@Id
	@GeneratedValue
	private Long transactionId;

	private String accountNumber;

	private BigDecimal transactionAmount;

	private TransactionType transactionType;

	private Timestamp transactionDateTime;

}
