package com.epam.training.familybank.service;

import java.math.BigDecimal;

import javax.persistence.NoResultException;

import org.springframework.transaction.annotation.Transactional;

import com.epam.training.familybank.dao.AccountDao;
import com.epam.training.familybank.dao.BankTransferDao;
import com.epam.training.familybank.dao.UserDao;
import com.epam.training.familybank.domain.Account;
import com.epam.training.familybank.domain.RoleType;
import com.epam.training.familybank.domain.User;

public class AdministratorService {

	private final UserDao userDao;
	private final AccountDao accountDao;
	private final BankTransferDao bankTransferDao;

	public AdministratorService(UserDao userDao, AccountDao accountDao, BankTransferDao bankTransferDao) {
		this.userDao = userDao;
		this.accountDao = accountDao;
		this.bankTransferDao = bankTransferDao;
	}

	@Transactional
	public void createClientWithAccount(String userName, String firstName, String lastName, String password) {
		User user = userDao.createUser(userName, firstName, lastName, password, RoleType.CLIENT);
		accountDao.createAccount(user);
	}

	@Transactional
	public Account getAccountByUsername(String userName) {
		try {
			return accountDao.getAccountByUsername(userName);
		} catch (NoResultException e) {
			throw new RuntimeException("User doesn't exist");
		}
	}

	@Transactional
	public void sendPaymentToAccount(String userName, BigDecimal payment) {
		Account account = getAccountByUsername(userName);
		account.setBalance(account.getBalance().add(payment));
	}
}
