package com.capstoneproject.FoodDeliveryApp.UserDetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstoneproject.FoodDeliveryApp.UserDetails.model.User;
import com.capstoneproject.FoodDeliveryApp.UserDetails.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService; 
		
	
	
	//Register a new user
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
	    User savedUser = userService.registerUser(user);
	    return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	}
	 @PostMapping("/login")
	    public ResponseEntity<?> loginUser(@RequestBody User user) {
	        boolean isAuthenticated = userService.authenticateUser(user.getUsername(), user.getPassword());
	        if (isAuthenticated) {
	            return ResponseEntity.ok("Login successful");
	        } else {
	            return ResponseEntity.status(401).body("Invalid credentials");
	        }
	    }
	
	
	@GetMapping("/{id}")
	public ResponseEntity<User>getUser(@PathVariable Long id){
		
		User user = userService.getUserById(id);
		if(user != null) {
			return new ResponseEntity<>(user,HttpStatus.OK); 
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
	}

}
