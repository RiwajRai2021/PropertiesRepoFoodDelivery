package com.capstoneproject.FoodDelivery.OrderDetails.orderController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.capstoneproject.FoodDelivery.OrderDetails.model.Order;
import com.capstoneproject.FoodDelivery.OrderDetails.service.OrderDetails;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired
	private OrderDetails orderDetails; 
	
	
	@PostMapping
	public ResponseEntity<String>createOrder(@RequestBody Order order){
		System.out.println("Created Order: " + order);
		return ResponseEntity.ok("Order created successfully.");
		
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Order>>getOrdersByUserId(@PathVariable Long userId){
		List<Order>orders=orderDetails.getOrderByUserId(userId);
		return ResponseEntity.ok(orders); 
	}
	
	@GetMapping("/restaurant/{restaurantId}")
	public ResponseEntity<List<Order>>getOrdersByRestaurantId(@PathVariable Long restaurantId){
		List<Order>orders = orderDetails.getOrdersByRestaurantId(restaurantId); 
		return ResponseEntity.ok(orders); 
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<Order>getOrderById(@PathVariable Long orderId){
		Order order = orderDetails.getOrderById(orderId); 
		return ResponseEntity.ok(order); 
	}
	
	public ResponseEntity<String>deleteOrder(@PathVariable Long id){
		orderDetails.deleteOrder(id);
		return ResponseEntity.ok("Order deleted successfully"); 
	}
	
	
}
