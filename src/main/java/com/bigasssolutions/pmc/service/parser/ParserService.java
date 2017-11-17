package com.bigasssolutions.pmc.service.parser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigasssolutions.pmc.dao.event.EventDaoImpl;
import com.bigasssolutions.pmc.model.Event;

@Service
public class ParserService {
	@Autowired
	private EventDaoImpl eventDao;

	public void createEvents(List<Event> events) {
//		for (Event event : events) {
//			eventDao.save(event);
//
//		}
		eventDao.save(events);
	}
}
