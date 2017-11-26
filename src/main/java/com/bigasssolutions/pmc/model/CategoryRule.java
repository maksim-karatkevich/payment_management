package com.bigasssolutions.pmc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "category_rule")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CategoryRule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "shop_name", unique = true)
	private String shop_name;
	@Column(name = "category_name")
	private String category_name;

	public CategoryRule(String shop_name, String category_name) {
		this.shop_name = shop_name;
		this.category_name = category_name;
	}

	public CategoryRule() {
	}

	public long getId() {
		return id;
	}

	public String getShop_name() {
		return shop_name;
	}

	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public void setId(long id) {
		this.id = id;
	}
}
