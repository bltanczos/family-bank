package com.epam.training.familybank.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericJpaDao {

	@PersistenceContext
	protected EntityManager entityManager;
}
