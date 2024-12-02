package com.capstoneproject.FoodDelivery.OrderDetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstoneproject.FoodDelivery.OrderDetails.model.Order;
import com.capstoneproject.FoodDelivery.OrderDetails.model.OrderStatus;
import com.capstoneproject.FoodDelivery.OrderDetails.repository.OrderRepository;

@Service
public class OrderDetailsImpl implements OrderDetails {

	@Autowired
	private OrderRepository orderRepository;
	
		
	public OrderDetailsImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public Order createOrder(Order order) {
		//Logic to calculate total price based on quantity and dish price
		//Assume a fixed dish price for now or fetch from Dish Service
		// order.setTotalAmount(order.getQuantity() * 10.0); // Example price: $10 per dish. 
		return orderRepository.save(order);
	}

	@Override
	public Order getOrderById(Long id) {
		return orderRepository.findById(id)
			.orElseThrow(() -> new RuntimeException("Order not found with id :" + id)); 
	}

	@Override
	public List<Order> getOrderByUserId(Long userId) {
		return orderRepository.findByUserId(userId);
		
	}

	@Override
	public List<Order> getOrdersByRestaurantId(Long restaurantId) {
		return orderRepository.findByRestaurantId(restaurantId); 
	}

	@Override
	public Order updateOrderStatus(Long id, String status) {
		Order order = getOrderById(id); 
		order.setOrderStatus(OrderStatus.valueOf(status.toUpperCase()));
		return orderRepository.save(order); 
	}

	@Override
	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);
		
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

		
	}
