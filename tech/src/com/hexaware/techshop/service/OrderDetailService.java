package com.hexaware.techshop.service;

import java.util.List;

import com.hexaware.techshop.entity.OrderDetail;



public interface OrderDetailService {
	int createOrderDetail(OrderDetail orddet);
	int removeOrderDetail(OrderDetail orddet);
//	int updateOrderDetail(OrderDetail orddet);
	
	List<OrderDetail> 	getAllOrderDetail();
} 
