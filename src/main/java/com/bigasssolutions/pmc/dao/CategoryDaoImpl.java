package com.bigasssolutions.pmc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.bigasssolutions.pmc.model.Category;

/**
 * Created by Maksim on 11/15/2017.
 */
public class CategoryDaoImpl implements DataBaseDao<Category> {

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(EventDaoImpl.class);

	@Autowired
	protected EntityManager entityManager;

	@Override
	public void save(Category entity) {
		entityManager.persist(entity);
	}

	@Override
	public List<Category> findAll() {
		return entityManager.createQuery("from Category").getResultList();
	}

	@Override
	public Category findById(long id) {
		Query query = entityManager.createQuery("select category from Category category where category.id = (:id)");
		query.setParameter("id", Long.valueOf(1));
		return (Category) query.getSingleResult();
	}

	@Override
	public void update() {
		// TODO: 11/15/2017 next time
	}
}
