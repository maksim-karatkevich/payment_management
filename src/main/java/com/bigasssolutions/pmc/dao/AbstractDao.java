package com.bigasssolutions.pmc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.bigasssolutions.pmc.dao.shop.ShopDaoImpl;

/**
 * Created by Maksim_Karatkevich on 11/17/2017.
 */
public class AbstractDao {
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	protected static final Logger logger = org.slf4j.LoggerFactory.getLogger(ShopDaoImpl.class);

	protected EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

	public void save(Object entity) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(entity);
			transaction.commit();
		}
		catch (RuntimeException ex) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
				logger.error("-------------------------------- " + ex + "-------------------------------------");
			}
		}
		finally {
			entityManager.close();
		}
	}

	public Object update(Object entity) {
		return getEntityManager().merge(entity);
	}

	public void remove(Object entity) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
			transaction.commit();
		}
		catch (RuntimeException ex) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
				logger.error("-------------------------------- " + ex + "-------------------------------------");
			}
		}
		finally {
			entityManager.close();
		}
	}
}
