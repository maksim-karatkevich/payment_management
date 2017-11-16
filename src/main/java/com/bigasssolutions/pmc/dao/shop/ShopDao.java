package com.bigasssolutions.pmc.dao.shop;

import java.util.List;

import com.bigasssolutions.pmc.model.Shop;

/**
 * Created by Maksim_Karatkevich on 11/16/2017.
 */
public interface ShopDao {
	void save(Shop shop);

	List<Shop> findAll();

	Shop findById(long id);

	Shop update(Shop shop);

	void remove(Shop shop);
}
