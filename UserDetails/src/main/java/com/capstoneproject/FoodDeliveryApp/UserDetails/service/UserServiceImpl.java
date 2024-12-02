
package com.capstoneproject.FoodDeliveryApp.UserDetails.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstoneproject.FoodDeliveryApp.UserDetails.model.User;
import com.capstoneproject.FoodDeliveryApp.UserDetails.repository.UserRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    //Register a new user
    @Override
    public User registerUser(User user) {
        User savedUser = userRepository.save(user);
        System.out.println("Saved User: " + savedUser);
        return savedUser;
    }

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	//Simple authentication (No JWT, no Hashing)
	@Override
	public boolean authenticateUser(String username, String password) {
	    User user = userRepository.findByUsername(username).orElse(null);

	    if (user != null) {
	        return user.getPassword().equals(password);
	    }
	    return false;
	}
}
