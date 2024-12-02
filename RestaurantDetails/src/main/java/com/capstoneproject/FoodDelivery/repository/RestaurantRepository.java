package com.capstoneproject.FoodDelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstoneproject.FoodDelivery.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
	//custom query method
	List<Restaurant>findByCuisine(String cuisine); 

}
