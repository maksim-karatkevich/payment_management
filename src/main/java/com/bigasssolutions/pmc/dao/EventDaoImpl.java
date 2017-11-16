package com.bigasssolutions.pmc.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bigasssolutions.pmc.model.Event;

@Repository
public class EventDaoImpl implements DataBaseDao<Event> {
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(EventDaoImpl.class);
	@Autowired
	private EntityManager entityManager;

	@Override
	public void save(Event event) {
		entityManager.getTransaction().begin();
		entityManager.persist(event);
		entityManager.getTransaction().commit();
		logger.info("Event successfully saved. Event details: " + event);
	}

	@Override
	public List<Event> findAll() {
		return entityManager.createQuery("from Event").getResultList();
	}

	@Override
	public void update() {

	}

	@Override
	public Event findById(long id) {
		return null;
	}

	public List<Event> getEventsByDate(Date date) {
		return null;
	}

	public List<Event> getEventsByCategory(long categoryId) {
		return null;
	}
}
