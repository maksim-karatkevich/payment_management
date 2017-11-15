package com.bigasssolutions.pmc.dao;

import java.util.Date;
import java.util.List;

import com.bigasssolutions.pmc.model.Event;

public interface EventDao {
	void saveEvent(Event event);
	List<Event> listEvents();
	List<Event> getEventsByCategory(long categoryId);
	List<Event> getEventsByDate(Date date);
}
