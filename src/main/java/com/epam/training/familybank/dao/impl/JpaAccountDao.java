package com.epam.training.familybank.dao.impl;

import java.math.BigDecimal;

import com.epam.training.familybank.dao.AccountDao;
import com.epam.training.familybank.domain.Account;
import com.epam.training.familybank.domain.User;

public class JpaAccountDao extends GenericJpaDao implements AccountDao {

	@Override
	public void createAccount(User owner) {
		Account account = new Account();
		account.setOwner(owner);
		account.setBalance(new BigDecimal(0));
		entityManager.persist(account);
	}

	@Override
	public Account getAccountByUsername(String userName) {
		final String QUERY = "SELECT a FROM Account a JOIN a.owner user WHERE user.userName = :userName";
		return entityManager.createQuery(QUERY, Account.class)
				.setParameter("userName", userName)
				.getSingleResult();
	}

}
