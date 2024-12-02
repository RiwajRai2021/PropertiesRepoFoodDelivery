package com.capstoneproject.FoodDelivery.OrderDetails.service;

import java.util.List;

import com.capstoneproject.FoodDelivery.OrderDetails.model.Order;

public interface OrderDetails {
	
	Order createOrder(Order order); 
	
	Order getOrderById(Long id); 
	
	Order updateOrderStatus(Long id, String status); 
	
	void deleteOrder(Long id); 
	
	List<Order>getAllOrders(); 
	
	List<Order>getOrderByUserId(Long userId); 
	// List<Order>getOrdersByRestaurantId();
	List<Order>getOrdersByRestaurantId(Long restaurantId); 
	
	
	

}
