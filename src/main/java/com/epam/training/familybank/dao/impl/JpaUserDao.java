package com.epam.training.familybank.dao.impl;

import com.epam.training.familybank.dao.UserDao;
import com.epam.training.familybank.domain.RoleType;
import com.epam.training.familybank.domain.User;

public class JpaUserDao extends GenericJpaDao implements UserDao {

	@Override
	public String getPasswordByUserName(String userName) {
		final String QUERY = "SELECT u.password FROM User u WHERE u.userName = :userName";
		return entityManager.createQuery(QUERY, String.class)
				.setParameter("userName", userName)
				.getSingleResult();
	}

	@Override
	public User getUserByUserName(String userName) {
		final String QUERY = "SELECT u FROM User u WHERE u.userName = :userName";
		return entityManager.createQuery(QUERY, User.class)
				.setParameter("userName", userName)
				.getSingleResult();
	}

	@Override
	public User createUser(String userName, String firstName, String lastName, String password, RoleType role) {
		User user = new User();
		user.setUserName(userName);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(password);
		user.setRole(role);
		entityManager.persist(user);
		return user;
	}

}
