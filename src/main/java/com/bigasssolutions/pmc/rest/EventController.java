package com.bigasssolutions.pmc.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bigasssolutions.pmc.model.Event;
import com.bigasssolutions.pmc.service.event.EventService;

@RestController
@RequestMapping(value = "/events", headers = "Accept=application/json", produces = "application/json")
public class EventController {

	@Autowired
	private EventService eventService;

	@RequestMapping(method = RequestMethod.POST)
	public void save(@RequestBody Event event) {
		eventService.save(event);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Event findById(@PathVariable long id) {
		return eventService.findById(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Event> findAll() {
		return eventService.findAll();
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Event update(@RequestBody Event event) {
		return eventService.update(event);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void remove(@RequestBody Event event) {
		eventService.remove(event);
	}
}
