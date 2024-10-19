package com.hexaware.techshop.service;

import java.util.List;

import com.hexaware.techshop.entity.Order;

public interface OrderService {
	int createOrder(Order ord);
	int removeOrder(Order ord);
	int updateOrder(Order ord);
	
	List<Order>	getAllOrder();

}
