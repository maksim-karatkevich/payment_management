package com.bigasssolutions.pmc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "category_rules")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CategoryRule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "shop_id")
	private long shop_id;
	@Column(name = "category_id")
	private long category_id;

	public CategoryRule() {
	}

	public long getId() {
		return id;
	}

	public long getShop_id() {
		return shop_id;
	}

	public void setShop_id(long shop_id) {
		this.shop_id = shop_id;
	}

	public long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
