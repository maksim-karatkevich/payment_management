package com.bigasssolutions.pmc.dao.category;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.bigasssolutions.pmc.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImpl implements CategoryDao{

	private static final String FIND_ALL_QUERY = "from Category";
	private static final String SELECT_CATEGORY_BY_ID_QUERY = "select category from Category category where category.id = (:id)";

	@Autowired
    private EntityManager entityManager;

	@Override
	public void save(Category entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
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
        return entityManager.merge(category);
    }

    @Override
    public void remove(Category category) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(category) ? category : entityManager.merge(category));
        entityManager.getTransaction().commit();
    }

}
