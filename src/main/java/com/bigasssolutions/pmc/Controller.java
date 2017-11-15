package com.bigasssolutions.pmc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bigasssolutions.pmc.dao.ShopDaoImpl;
import com.bigasssolutions.pmc.model.Shop;

@RestController
public class Controller {

	@Autowired
	private ShopDaoImpl shopDao;

	@RequestMapping(value = "/shops", method = RequestMethod.GET)
	public Shop findAll() {
		return shopDao.findById(1);
	}

}
