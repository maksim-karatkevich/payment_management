package com.bigasssolutions.pmc.dao.category;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bigasssolutions.pmc.dao.AbstractDao;
import com.bigasssolutions.pmc.model.Category;

@Repository
public class CategoryDaoImpl extends AbstractDao implements CategoryDao {

	private static final String FIND_ALL_QUERY = "from Category";
	private static final String SELECT_CATEGORY_BY_ID_QUERY = "select category from Category category where category.id = (:id)";

	@Override
	public void save(Category category) {
		super.save(category);
	}

	@Override
	public List<Category> findAll() {
		return getEntityManager().createQuery(FIND_ALL_QUERY, Category.class).getResultList();
	}

	@Override
	public Category findById(long id) {
		Query query = getEntityManager().createQuery(SELECT_CATEGORY_BY_ID_QUERY);
		query.setParameter("id", id);
		return (Category) query.getSingleResult();
	}

	@Override
	public Category update(Category category) {
		return (Category) super.update(category);
	}

	@Override
	public void remove(Category category) {
		super.remove(category);
	}

}
