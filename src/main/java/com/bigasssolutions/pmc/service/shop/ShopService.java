package com.bigasssolutions.pmc.service.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigasssolutions.pmc.dao.shop.ShopDaoImpl;
import com.bigasssolutions.pmc.model.Shop;

@Service
public class ShopService {

	@Autowired
	private ShopDaoImpl shopDao;

	public void save(Shop shop) {
		shopDao.save(shop);
	}

	public Shop findById(long id) {
		return shopDao.findById(id);
	}

	public List<Shop> findAll() {
		return shopDao.findAll();
	}

	public Shop update(Shop shop) {
		return shopDao.update(shop);
	}

	public void remove(Shop shop) {
		shopDao.remove(shop);
	}
}
