package com.epam.training.familybank.dao;

import com.epam.training.familybank.domain.RoleType;
import com.epam.training.familybank.domain.User;

public interface UserDao {
	
	public String getPasswordByUserName(String userName);
	
	public User getUserByUserName(String userName);
	
	public User createUser(String userName, String firstName, String lastName, String password, RoleType role);

}
