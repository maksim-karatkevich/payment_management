package com.bigasssolutions.pmc.dao.category;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.bigasssolutions.pmc.dao.EventDaoImpl;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.bigasssolutions.pmc.model.Category;
import org.springframework.stereotype.Repository;

/**
 * Created by Maksim on 11/15/2017.
 */
@Repository
public class CategoryDaoImpl implements CategoryDao{

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(EventDaoImpl.class);

	private static final String FIND_ALL_QUERY = "from Category";
	private static final String SELECT_CATEGORY_BY_ID_QUERY = "select category from Category category where category.id = (:id)";

	@Autowired
    private EntityManager entityManager;

	@Override
	public void save(Category entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
        logger.info("category saved : " + entity);
	}

	@Override
	public List<Category> findAll() {
	    return entityManager.createQuery(FIND_ALL_QUERY, Category.class).getResultList();
	}

	@Override
	public Category findById(long id) {
		Query query = entityManager.createQuery(SELECT_CATEGORY_BY_ID_QUERY);
		query.setParameter("id", id);
		return (Category) query.getSingleResult();
	}

	@Override
	public Category update(Category category) {
        Category updatedCategory = entityManager.merge(category);
        logger.info("category updated : " + updatedCategory);
		return updatedCategory;
	}

    @Override
    public void remove(Category category) {
        entityManager.remove(category);
    }

}
