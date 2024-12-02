package com.capstoneproject.FoodDelivery.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstoneproject.FoodDelivery.model.Dish;

public interface DishRepository extends JpaRepository<Dish,Long>{

	List<Dish>findByRestaurantId(Long restaurantId);

	Optional<Dish> findByIdAndRestaurantId(Long dishId, Long restaurantId);
	 
}
