package com.capstoneproject.FoodDelivery.OrderDetails.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	
	@Column(name="user_id", nullable = false)
	private Long userId; 
	
	@Column(name="restaurant_id", nullable = false)
	private Long restaurantId;
	
	@Column(name = "dish_id", nullable = false)
	private Long dishId; 
	
	@Column(name = "quantity", nullable = false)
	private int quantity; 
	
	@Column(name = "total_amount", nullable = false)
	private Double totalAmount; 
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date orderDate = new Date(); 
	
	@ElementCollection
	@CollectionTable(name = "order_dishes", joinColumns = @JoinColumn(name="order_id"))
	@Column(name="dish_id")
	private List<Long>dishIds; 
	
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	private Restaurant resturant; 
	

	@Enumerated(EnumType.STRING)
	@Column(name="orderStatus", nullable = false)
	private OrderStatus orderStatus = OrderStatus.PENDING; //DEFAULT STATUS
		

	public Order(Long id, Long userId, Long restaurantId, Long dishId, Double totalAmount, Date orderDate,
			OrderStatus orderStatus) {
		super();
		this.id = id;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.dishId = dishId;
		this.totalAmount = totalAmount;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}

	public Long getDishId() {
		return dishId;
	}

	public void setDishId(Long dishId) {
		this.dishId = dishId;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus getStatus() {
		return orderStatus;
	}

	public void setStatus(OrderStatus status) {
		this.orderStatus = status;
	}
	
	
	public List<Long> getDishIds() {
		return dishIds;
	}

	public void setDishIds(List<Long> dishIds) {
		this.dishIds = dishIds;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", restaurantId=" + restaurantId + ", dishId=" + dishId
				+ ", quantity=" + quantity + ", totalAmount=" + totalAmount + ", orderDate=" + orderDate
				+ ", orderStatus=" + orderStatus + "]";
	}

	

}
