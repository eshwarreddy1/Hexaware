package com.hexaware.techshop.dao;

import java.util.List;

import com.hexaware.techshop.entity.Order;


public interface OrderDao {
	int createOrder(Order ord);
	int removeOrder(Order ord);
	int updateOrder(Order ord);
	
	List<Order> 	getAllOrder();
	

}
