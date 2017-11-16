package com.bigasssolutions.pmc;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bigasssolutions.pmc.dao.EventDaoImpl;
import com.bigasssolutions.pmc.dao.shop.ShopDaoImpl;
import com.bigasssolutions.pmc.model.Category;
import com.bigasssolutions.pmc.model.Event;
import com.bigasssolutions.pmc.model.Shop;

@RestController
public class Controller {

	@Autowired
	private ShopDaoImpl shopDao;
	@Autowired
	private EventDaoImpl eventDao;

	@RequestMapping(value = "/shops", method = RequestMethod.GET)
	public List<Shop> findAllShops() {
		return shopDao.findAll();
	}

	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public List<Event> findAllEvents() {
		eventDao.save(new Event(new Date(), 1.1, new Category("Food"), new Shop("Krasavic")));
		return eventDao.findAll();
	}

}
