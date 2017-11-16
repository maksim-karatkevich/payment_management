package com.bigasssolutions.pmc.dao.shop;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bigasssolutions.pmc.dao.EventDaoImpl;
import com.bigasssolutions.pmc.model.Shop;

@Repository
public class ShopDaoImpl implements ShopDao {

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(EventDaoImpl.class);
	private static final String FIND_ALL_QUERY = "from Shop";
	private static final String SELECT_CATEGORY_BY_ID_QUERY = "select shop from Shop shop where shop.id = (:id)";

	@Autowired
	protected EntityManager entityManager;

	@Override
	public void save(Shop shop) {
		entityManager.getTransaction().begin();
		entityManager.persist(shop);
		entityManager.getTransaction().commit();
		logger.info("Shop saved: " + shop);
	}

	public List<Shop> findAll() {
		return entityManager.createQuery(FIND_ALL_QUERY).getResultList();
	}

	@Override
	public Shop findById(long id) {
		Query query = entityManager.createQuery(SELECT_CATEGORY_BY_ID_QUERY);
		query.setParameter("id", Long.valueOf(1));
		return (Shop) query.getSingleResult();
	}

	@Override
	public Shop update(Shop shop) {
		Shop updatedShop = entityManager.merge(shop);
		logger.info("Shop updated : " + updatedShop);
		return updatedShop;
	}

	@Override
	public void remove(Shop entity) {
		entityManager.remove(entity);
	}
}
