package com.bigasssolutions.pmc.dao.event;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.bigasssolutions.pmc.model.Event;

/**
 * Created by Maksim_Karatkevich on 11/16/2017.
 */
public class EventDaoImpl implements EventDao {
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(EventDaoImpl.class);
	private static final String FIND_ALL_QUERY = "from Event";
	private static final String SELECT_CATEGORY_BY_ID_QUERY = "select event from Event event where event.id = (:id)";

	@Autowired
	protected EntityManager entityManager;

	@Override
	public void save(Event event) {
		entityManager.getTransaction().begin();
		entityManager.persist(event);
		entityManager.getTransaction().commit();
		logger.info("event saved: " + event);
	}

	@Override
	public List<Event> findAll() {
		return entityManager.createQuery(FIND_ALL_QUERY).getResultList();
	}

	@Override
	public Event findById(long id) {
		Query query = entityManager.createQuery(SELECT_CATEGORY_BY_ID_QUERY);
		query.setParameter("id", Long.valueOf(1));
		return (Event) query.getSingleResult();
	}

	@Override
	public List<Event> findByPeriod(String start, String end) {
		return null;
	}

	@Override
	public Event update(Event event) {
		Event updatedEvent = entityManager.merge(event);
		logger.info("Event updated : " + updatedEvent);
		return updatedEvent;
	}

	@Override
	public void remove(Event event) {
		entityManager.remove(event);
	}
}
