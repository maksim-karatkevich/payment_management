package com.bigasssolutions.pmc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bigasssolutions.pmc.model.Shop;

@Repository
public class ShopDaoImpl extends AbstractDao {


    public List<Shop> findAll() {
        return entityManager.createQuery("from Shop").getResultList();
    }

    @Override
    public Shop findById(long id) {
        Query query = entityManager.createQuery("select shop from Shop shop where shop.id = (:id)");
        query.setParameter("id", Long.valueOf(1));
        return (Shop) query.getSingleResult();
    }

    @Override
    public void updateEntity() {
        // TODO: 11/15/2017 next time
    }
}
