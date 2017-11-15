package com.bigasssolutions.pmc.dao;

import com.bigasssolutions.pmc.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

/**
 * Created by Maksim on 11/15/2017.
 */
public abstract class AbstractDao implements DataBaseDao {
    @Autowired
    protected EntityManager entityManager;

    @Override
    public void saveEntity(Object entity) {
        entityManager.persist(entity);
    }
}
