package com.bigasssolutions.pmc.dao;

import com.bigasssolutions.pmc.model.Category;
import com.bigasssolutions.pmc.model.Shop;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Maksim on 11/15/2017.
 */
public class CategoryDaoImpl extends AbstractDao {

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
    public void updateEntity() {
        // TODO: 11/15/2017 next time
    }
}
