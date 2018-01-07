package com.epam.training.familybank.spring;

import org.springframework.context.annotation.Bean;

import com.epam.training.familybank.dao.AccountDao;
import com.epam.training.familybank.dao.BankTransferDao;
import com.epam.training.familybank.dao.UserDao;
import com.epam.training.familybank.dao.impl.JpaAccountDao;
import com.epam.training.familybank.dao.impl.JpaBankTransferDao;
import com.epam.training.familybank.dao.impl.JpaUserDao;

public class SpringConfigurationDao {

	@Bean
	public UserDao userDao() {
		return new JpaUserDao();
	}
	
	@Bean
	public AccountDao accountDao() {
		return new JpaAccountDao();
	}
	
	@Bean
	public BankTransferDao bankTransferDao() {
		return new JpaBankTransferDao();
	}
}
