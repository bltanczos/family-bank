package com.epam.training.familybank.service;

import java.math.BigDecimal;

import javax.persistence.NoResultException;

import org.springframework.transaction.annotation.Transactional;

import com.epam.training.familybank.dao.AccountDao;
import com.epam.training.familybank.dao.BankTransferDao;
import com.epam.training.familybank.dao.UserDao;
import com.epam.training.familybank.domain.Account;

public class ClientService {

	private final UserDao userDao;
	private final AccountDao accountDao;
	private final BankTransferDao bankTransferDao;

	public ClientService(UserDao userDao, AccountDao accountDao, BankTransferDao bankTransferDao) {
		this.userDao = userDao;
		this.accountDao = accountDao;
		this.bankTransferDao = bankTransferDao;
	}

	@Transactional
	public void sendFromClientToClient(String senderUserName, String receiverUserName, BigDecimal amount) {
		Account senderAccount, receiverAccount;
		try {
			senderAccount = accountDao.getAccountByUsername(senderUserName);
			receiverAccount = accountDao.getAccountByUsername(receiverUserName);
		} catch (NoResultException e) {
			throw new RuntimeException("Receiver client doesn't exist");
		}
		
		if (senderAccount.getBalance().compareTo(amount) == -1) {
			throw new RuntimeException("Not enough money for this transaction");
		}

		senderAccount.setBalance(senderAccount.getBalance().subtract(amount));
		receiverAccount.setBalance(receiverAccount.getBalance().add(amount));
	}

	@Transactional
	public void sendFromBankToClient(String userName, BigDecimal amount) {
		try {
			sendFromClientToClient("admin", userName, amount);
		} catch (RuntimeException e) {
			throw new RuntimeException("Bank has not enough money for this transaction");
		}
	}

	@Transactional
	public void sendFromClientToBank(String userName, BigDecimal amount) {
		sendFromClientToClient(userName, "admin", amount);
	}

	@Transactional
	public BigDecimal getBalanceByUsername(String userName) {
		return accountDao.getAccountByUsername(userName).getBalance();
	}

	@Transactional
	public void withdrawMoneyFromAccount(String userName, BigDecimal amount) {
		Account account = accountDao.getAccountByUsername(userName);

		if (account.getBalance().compareTo(amount) == -1) {
			throw new RuntimeException("Not enough money for this transaction");
		}

		account.setBalance(account.getBalance().subtract(amount));
	}
}
