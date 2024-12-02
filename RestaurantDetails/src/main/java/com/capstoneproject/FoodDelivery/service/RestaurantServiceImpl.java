package com.capstoneproject.FoodDelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstoneproject.FoodDelivery.exception.ResourceNotFoundException;
import com.capstoneproject.FoodDelivery.model.Restaurant;
import com.capstoneproject.FoodDelivery.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantDetails{
	
	@Autowired
	private RestaurantRepository restaurantRepository; 
	
	
	public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository; 
	}
	

	@Override
	public Restaurant createRestaurant(Restaurant restaurant) {
		return restaurantRepository.save(restaurant); 
	}
	
	@Override
    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + id));
    }


	@Override
	public List<Restaurant>getAllRestaurants() {
		return restaurantRepository.findAll();
	}

	
    public Restaurant updateRestaurant(Long id, Restaurant updatedRestaurant) {
        return restaurantRepository.findById(id)
                .map(restaurant -> {
                    restaurant.setName(updatedRestaurant.getName());
                    restaurant.setRating(updatedRestaurant.getRating());
                    restaurant.setLocation(updatedRestaurant.getLocation());
                    return restaurantRepository.save(restaurant);
                }).orElseThrow(() -> new RuntimeException("Restaurant not found"));
    }

	@Override
	public void deleteRestaurant(Long id) {
		restaurantRepository.deleteById(id);
		
	}
	
	@Override
	public List<Restaurant> getRestaurantsByCuisine(String cuisine) {
		return restaurantRepository.findByCuisine(cuisine); 
	}

}
