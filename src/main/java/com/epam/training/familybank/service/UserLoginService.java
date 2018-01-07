package com.epam.training.familybank.service;

import org.springframework.transaction.PlatformTransactionManager;

import com.epam.training.familybank.dao.AccountDao;
import com.epam.training.familybank.dao.UserDao;
import com.epam.training.familybank.domain.User;


public class UserLoginService {
	private final UserDao userDao;
	private final AccountDao accountDao;
	
	private PlatformTransactionManager txManager;
	private String userName;
	
	public UserLoginService(UserDao userDao, AccountDao accountDao) {
		this.userDao = userDao;
		this.accountDao = accountDao;
	}
	
	public void authenticateUser(String userName, String password) {
		String storedPassword = userDao.getPasswordByUserName(userName);
		if(storedPassword == null || !password.equals(storedPassword)) {
			throw new RuntimeException("Username or password is not correct!");
		}
		this.userName = userName;
	}
	
	public User getUserInfo() {
		return userDao.getUserByUserName(userName);
	}

	public String getUserName() {
		return userName;
	}
	
}
