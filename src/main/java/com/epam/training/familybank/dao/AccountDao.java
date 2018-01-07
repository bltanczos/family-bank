package com.epam.training.familybank.dao;

import com.epam.training.familybank.domain.Account;
import com.epam.training.familybank.domain.User;

public interface AccountDao {
	
	public void createAccount(User owner);
	
	public Account getAccountByUsername(String userName);
}
