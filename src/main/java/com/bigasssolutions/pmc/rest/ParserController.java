package com.bigasssolutions.pmc.rest;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bigasssolutions.pmc.model.Event;
import com.bigasssolutions.pmc.service.event.EventService;
import com.bigasssolutions.pmc.service.parser.ParserService;
import com.bigasssolutions.pmc.utils.parser.CSVEventParser;

@RestController
@RequestMapping(value = "/parser", headers = "Accept=application/json", produces = "application/json")
public class ParserController {

	private final static String FROM_ENCODING = "windows-1251";
	private final static String TO_ENCODING = "UTF-8";
	private final static String FILE_URL = "http://localhost:8080/parser?url=C%3A%5CUsers%5CMaksim_Karatkevich%5CDesktop%5Cper%5CVpsk.csv";


	@Autowired
	private ParserService parserService;
	@Autowired
	private EventService eventService;

	@RequestMapping(method = RequestMethod.GET)
	public void parse(@RequestParam("url") String url) {
		try {
			List<Event> events = CSVEventParser.parse(url);
			parserService.createEvents(events);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
