package com.capstoneproject.FoodDelivery.service;

import java.util.List;

import com.capstoneproject.FoodDelivery.model.Restaurant;

public interface RestaurantDetails {
	
	Restaurant createRestaurant(Restaurant restaurant); 
	
	List<Restaurant>getAllRestaurants();
	
	Restaurant getRestaurantById(Long id); 
	
	Restaurant updateRestaurant(Long id, Restaurant restaurant); 
	
	void deleteRestaurant(Long id);

	List<Restaurant> getRestaurantsByCuisine(String cuisine); 

}
