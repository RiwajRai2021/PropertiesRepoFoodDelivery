package com.capstoneproject.FoodDelivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstoneproject.FoodDelivery.model.Dish;
import com.capstoneproject.FoodDelivery.model.Restaurant;
import com.capstoneproject.FoodDelivery.service.DishDetails;
import com.capstoneproject.FoodDelivery.service.RestaurantDetails;



@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

	@Autowired
	private DishDetails dishDetails; 
    @Autowired
    private RestaurantDetails restaurantDetails;
    
    public RestaurantController(RestaurantDetails restaurantDetails) {
    	this.restaurantDetails = restaurantDetails; 
    }
    // Create a new restaurant
    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant savedRestaurant = restaurantDetails.createRestaurant(restaurant);
        return new ResponseEntity<>(savedRestaurant, HttpStatus.CREATED);
    }

    // Get all restaurants
    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        List<Restaurant> restaurants =  restaurantDetails.getAllRestaurants();
        return ResponseEntity.ok(restaurants);
    }

    //Get Restaurants by cuisine
    @GetMapping("/cuisine/{cuisine}")
    public ResponseEntity<List<Restaurant>> getRestaurantsByCuisine(@PathVariable String cuisine) {
    	List<Restaurant>restaurants = restaurantDetails.getRestaurantsByCuisine(cuisine); 
    	return ResponseEntity.ok(restaurants); 
    	
    }
   
    // Update restaurant details
    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id, @RequestBody Restaurant updatedRestaurant) {
        Restaurant updated = restaurantDetails.updateRestaurant(id, updatedRestaurant);
        return ResponseEntity.ok(updatedRestaurant);
    }

    // Delete restaurant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
    	 restaurantDetails.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }
    

    // ------------------- Dish Endpoints -------------------

    // Add a dish to a restaurant
    @PostMapping("/{restaurantId}/dishes")
    public ResponseEntity<Dish> addDishToRestaurant(@PathVariable Long restaurantId, @RequestBody Dish dish) {
        System.out.println("Received payload: " + dish);
    	Dish savedDish = dishDetails.addDishToRestaurant(restaurantId, dish);
        return new ResponseEntity<>(savedDish, HttpStatus.CREATED);
    }

    
}