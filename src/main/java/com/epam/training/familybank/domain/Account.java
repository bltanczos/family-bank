package com.epam.training.familybank.domain;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	private User owner;
	
	@OneToMany(mappedBy="account")
	private Collection<BankTransfer> bankTransfers;
	
	private BigDecimal balance;

	public int getId() {
		return id;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Collection<BankTransfer> getBankTransfers() {
		return bankTransfers;
	}

	public void setBankTransfers(Collection<BankTransfer> bankTransfers) {
		this.bankTransfers = bankTransfers;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	
}
