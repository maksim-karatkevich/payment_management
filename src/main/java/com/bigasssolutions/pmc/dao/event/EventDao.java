package com.bigasssolutions.pmc.dao.event;

import java.util.List;

import com.bigasssolutions.pmc.model.Event;


public interface EventDao {

	void save(Event event);

	List<Event> findAll();

	List<Event> findByPeriod(String start, String end);

	Event findById(long id);

	Event update(Event event);

	void remove(Event event);
}
