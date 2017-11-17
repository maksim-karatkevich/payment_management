package com.bigasssolutions.pmc.service.parser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bigasssolutions.pmc.dao.event.EventDaoImpl;
import com.bigasssolutions.pmc.model.Event;

@Service
public class ParserService {
	@Autowired
	private EventDaoImpl eventDao;

	@Transactional(propagation = Propagation.REQUIRED)
	public void createEvents(List<Event> events) {
		eventDao.save(events);
	}
}
