package com.bigasssolutions.pmc.dao.shop;

import java.util.List;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import com.bigasssolutions.pmc.dao.AbstractDao;
import com.bigasssolutions.pmc.model.Shop;

@Repository
public class ShopDaoImpl extends AbstractDao implements ShopDao {

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(ShopDaoImpl.class);
	private static final String FIND_ALL_QUERY = "from Shop";
	private static final String SELECT_CATEGORY_BY_ID_QUERY = "select shop from Shop shop where shop.id = (:id)";

	@Override
	public void save(Shop shop) {
		super.save(shop);
	}

	public List<Shop> findAll() {
		return getEntityManager().createQuery(FIND_ALL_QUERY).getResultList();
	}

	@Override
	public Shop findById(long id) {
		Query query = getEntityManager().createQuery(SELECT_CATEGORY_BY_ID_QUERY);
		query.setParameter("id", Long.valueOf(1));
		return (Shop) query.getSingleResult();
	}

	@Override
	public Shop update(Shop shop) {
		return (Shop) super.update(shop);
	}

	@Override
	public void remove(Shop shop) {
		super.remove(shop);
	}
}
