package com.capstoneproject.FoodDelivery.service;

import java.util.List;

import com.capstoneproject.FoodDelivery.model.Dish;

public interface DishDetails {
	
	Dish addDishToRestaurant(Long restaurantId, Dish dish);
	
	List<Dish>getDishesByRestaurant(Long restaurantId); 
	
	void deleteDish(Long restaurantId, Long dishId); 
	
	}

