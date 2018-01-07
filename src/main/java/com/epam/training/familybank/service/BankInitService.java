package com.epam.training.familybank.service;

import javax.persistence.NoResultException;

import org.springframework.transaction.annotation.Transactional;

import com.epam.training.familybank.dao.AccountDao;
import com.epam.training.familybank.dao.UserDao;
import com.epam.training.familybank.domain.RoleType;
import com.epam.training.familybank.domain.User;

public class BankInitService {

	private final UserDao userDao;
	private final AccountDao accountDao;

	private final String ADMIN = "admin";
	private final String PASSWORD = "admin";
	private final String FIRST_NAME = "Mr.";
	private final String LAST_NAME = "Admin";

	public BankInitService(UserDao userDao, AccountDao accountDao) {
		this.userDao = userDao;
		this.accountDao = accountDao;
	}

	@Transactional
	public void createBankAccount(User owner) {
		accountDao.createAccount(owner);
	}

	@Transactional
	public User createAdminUser() {
		User admin = null;
		try {
			admin = userDao.createUser(ADMIN, FIRST_NAME, LAST_NAME, PASSWORD, RoleType.ADMINISTRATOR);
		} catch (NoResultException e) {
			throw new RuntimeException("Admin already exists");
		}
		return admin;
	}
}
