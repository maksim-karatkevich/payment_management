package com.bigasssolutions.pmc.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bigasssolutions.pmc.model.Event;

@Repository
public class EventDaoImpl implements EventDao {
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(EventDaoImpl.class);
	@Autowired
	private EntityManager entityManager;

	@Override
	public void saveEvent(Event event) {
		entityManager.persist(event);
		logger.info("Event successfully saved. Event details: " + event);
	}

	@Override
	public List<Event> listEvents() {
		return null;
	}

	@Override
	public List<Event> getEventsByCategory(long categoryId) {
		return null;
	}

	@Override
	public List<Event> getEventsByDate(Date date) {
		return null;
	}
}
