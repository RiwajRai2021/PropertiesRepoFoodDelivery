package com.capstoneproject.FoodDeliveryApp.UserDetails.service;

import org.springframework.stereotype.Service;

import com.capstoneproject.FoodDeliveryApp.UserDetails.model.User;

@Service
public interface UserService {
	
		
	//Register a new user 
	User registerUser(User user); 
	
	//Find a user by username 
	User findByUsername(String username); 
	
	
	User getUserById(Long id);

	boolean authenticateUser(String username, String password); 
	
	

}
