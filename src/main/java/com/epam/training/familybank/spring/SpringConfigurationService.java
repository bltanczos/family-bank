package com.epam.training.familybank.spring;

import org.springframework.context.annotation.Bean;

import com.epam.training.familybank.dao.AccountDao;
import com.epam.training.familybank.dao.BankTransferDao;
import com.epam.training.familybank.dao.UserDao;
import com.epam.training.familybank.service.AdministratorService;
import com.epam.training.familybank.service.BankInitService;
import com.epam.training.familybank.service.ClientService;
import com.epam.training.familybank.service.UserLoginService;

public class SpringConfigurationService {

	@Bean
	public BankInitService bankInitService(UserDao userDao, AccountDao accountDao) {
		return new BankInitService(userDao, accountDao);
	}
	
	@Bean
	public UserLoginService userLoginService(UserDao userDao, AccountDao accountDao) {
		return new UserLoginService(userDao, accountDao);
	}
	
	@Bean
	public AdministratorService administratorService(UserDao userDao, AccountDao accountDao, BankTransferDao bankTransferDao) {
		return new AdministratorService(userDao, accountDao, bankTransferDao);
	}
	
	@Bean
	public ClientService clientService(UserDao userDao, AccountDao accountDao, BankTransferDao bankTransferDao) {
		return new ClientService(userDao, accountDao, bankTransferDao);
	}
}
