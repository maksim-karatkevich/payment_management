package com.bigasssolutions.pmc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "event")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Event implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "date")
	private Date date;
	@Column(name = "sum")
	private double sum;
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "shop_id")
	private Shop shop;

	public Event() {
	}

	public Event(Date date, double sum, Category category, Shop shop) {
		this.date = date;
		this.sum = sum;
		this.category = category;
		this.shop = shop;
	}

	public Event(long id, Date date, double sum, Category category, Shop shop) {
		this(id, date, sum, shop);
		this.category = category;
	}

	public Event(long id, Date date, double sum, Shop shop) {
		this.id = id;
		this.date = date;
		this.sum = sum;
		this.shop = shop;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@Override
	public String toString() {
		return "Event{" +
				"id=" + id +
				", date=" + date +
				", sum=" + sum +
				", category=" + category +
				", shop=" + shop +
				'}';
	}
}
