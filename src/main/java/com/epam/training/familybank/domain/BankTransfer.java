package com.epam.training.familybank.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BankTransfer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Account account;
	private Date transferDate;
	
	private BigDecimal amount;
	private BigDecimal interestRate;
	private Date lastInterestPaymentDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Date getTransferDate() {
		return transferDate;
	}
	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}
	public Date getLastInterestPaymentDate() {
		return lastInterestPaymentDate;
	}
	public void setLastInterestPaymentDate(Date lastInterestPaymentDate) {
		this.lastInterestPaymentDate = lastInterestPaymentDate;
	}
	
	

}
