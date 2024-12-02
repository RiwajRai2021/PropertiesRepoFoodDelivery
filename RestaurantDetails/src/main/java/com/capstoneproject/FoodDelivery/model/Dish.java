package com.capstoneproject.FoodDelivery.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="dishes")
public class Dish {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	
	@NotNull
	@Size(min=3, max=50, message = "Dish name must be between 3 and 50 characters")
	private String name; 
	
	@NotNull(message = "Price is required")
	@Column(nullable = false)
	private Double price;
	
	@Column(nullable = false)
	private String description; 
		
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="restaurant_id", nullable = false)
	private Restaurant restaurant;

	public Dish() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "Dish [id=" + id + ", name=" + name + ", price=" + price + ", restaurant=" + restaurant + "]";
	}

	
	

}
