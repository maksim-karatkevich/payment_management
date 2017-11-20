package com.bigasssolutions.pmc.dao.event;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bigasssolutions.pmc.dao.AbstractDao;
import com.bigasssolutions.pmc.model.Event;
import com.bigasssolutions.pmc.model.Shop;

@Repository
public class EventDaoImpl extends AbstractDao implements EventDao {

	private static final String FIND_ALL_QUERY = "from Event";
	private static final String SELECT_CATEGORY_BY_ID_QUERY = "select event from Event event where event.id = (:id)";

	public void save(List<Event> events) {
		for (Event event : events) {
			save(event);
		}
	}

	@Override
	public void save(Event event) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			String shopName = event.getShop().getName();

			Query query = entityManager.createQuery("select shop from Shop shop where shop.name = (:name)");
			query.setParameter("name", String.valueOf(shopName));
			List<Shop> list = query.getResultList();
			if (list.size() > 0) {
				Shop shop = list.get(0);
				event.setShop(shop);
			}
			entityManager.persist(event);
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

	@Override
	public List<Event> findAll() {
		return getEntityManager().createQuery(FIND_ALL_QUERY).getResultList();
	}

	@Override
	public Event findById(long id) {
		Query query = getEntityManager().createQuery(SELECT_CATEGORY_BY_ID_QUERY);
		query.setParameter("id", Long.valueOf(1));
		return (Event) query.getSingleResult();
	}

	@Override
	public List<Event> findByPeriod(String start, String end) {
		return null;
	}

	@Override
	public Event update(Event event) {
		return (Event) super.update(event);
	}

	@Override
	public void remove(Event event) {
		super.remove(event);
	}
}
