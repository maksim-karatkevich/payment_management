package com.bigasssolutions.pmc.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bigasssolutions.pmc.model.Shop;
import com.bigasssolutions.pmc.service.shop.ShopService;

@RestController
@RequestMapping(value = "/shops", headers = "Accept=application/json", produces = "application/json")
public class ShopController {
	@Autowired
	private ShopService shopService;

	@RequestMapping(method = RequestMethod.POST)
	public void save(@RequestBody Shop category) {
		shopService.save(category);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Shop findById(@PathVariable long id) {
		return shopService.findById(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Shop> findAll() {
		return shopService.findAll();
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Shop update(@RequestBody Shop category) {
		return shopService.update(category);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void remove(@RequestBody Shop category) {
		shopService.remove(category);
	}
}
