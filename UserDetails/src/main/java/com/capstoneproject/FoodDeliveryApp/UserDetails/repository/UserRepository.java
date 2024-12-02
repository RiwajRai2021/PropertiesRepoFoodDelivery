package com.capstoneproject.FoodDeliveryApp.UserDetails.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstoneproject.FoodDeliveryApp.UserDetails.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User>findByUsername(String username);
	
	User findByEmail(String email); 
}
