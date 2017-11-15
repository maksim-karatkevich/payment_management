package com.bigasssolutions.pmc.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bigasssolutions.pmc.model.Shop;

/**
 * Created by Maksim_Karatkevich on 11/15/2017.
 */
@Repository
public class ShopDaoImpl {
	@Autowired
	private EntityManager entityManager;

	public List<Shop> findAll() {
		List<Shop> list = entityManager.createQuery("from Shop").getResultList();
		System.out.println(list);
		return list;
	}

}
