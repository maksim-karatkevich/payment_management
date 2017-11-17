package com.bigasssolutions.pmc.service.event;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigasssolutions.pmc.dao.event.EventDaoImpl;
import com.bigasssolutions.pmc.model.Event;

@Service
public class EventService {
	@Autowired
	private EventDaoImpl eventDao;

	public void save(Event event) {
		eventDao.save(event);
	}

	public Event findById(long id) {
		return eventDao.findById(id);
	}

	public List<Event> findAll() {
		return eventDao.findAll();
	}

	public Event update(Event event) {
		return eventDao.update(event);
	}

	public void remove(Event event) {
		eventDao.remove(event);
	}
}
