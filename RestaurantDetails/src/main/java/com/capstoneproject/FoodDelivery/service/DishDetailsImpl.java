package com.capstoneproject.FoodDelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstoneproject.FoodDelivery.exception.ResourceNotFoundException;
import com.capstoneproject.FoodDelivery.model.Dish;
import com.capstoneproject.FoodDelivery.model.Restaurant;
import com.capstoneproject.FoodDelivery.repository.DishRepository;
import com.capstoneproject.FoodDelivery.repository.RestaurantRepository;

@Service
public class DishDetailsImpl implements DishDetails {
	
	@Autowired
	private RestaurantRepository restaurantRepository; 
	
	@Autowired
	private DishRepository dishRepository; 
	
	@Override
	public Dish addDishToRestaurant(Long restaurantId, Dish dish) {
	    Restaurant restaurant = restaurantRepository.findById(restaurantId)
	            .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + restaurantId));

	    dish.setRestaurant(restaurant); // Associate dish with the restaurant
	    return dishRepository.save(dish); // Save the dish
	}

	@Override
	public List<Dish> getDishesByRestaurant(Long restaurantId) {
		return dishRepository.findByRestaurantId(restaurantId); // Custom query in DishRepository. 
	}

	@Override
	public void deleteDish(Long restaurantId, Long dishId) {
	    Dish dish = dishRepository.findByIdAndRestaurantId(dishId, restaurantId)
	            .orElseThrow(() -> new ResourceNotFoundException("Dish not found with id: " + dishId + " for restaurant id: " + restaurantId));

	    dishRepository.delete(dish); // Delete the dish
	}


}
