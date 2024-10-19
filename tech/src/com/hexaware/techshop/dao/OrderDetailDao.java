package com.hexaware.techshop.dao;

import java.util.List;

import com.hexaware.techshop.entity.OrderDetail;



public interface OrderDetailDao {
	int createOrderDetail(OrderDetail orddet);
	int removeOrderDetail(OrderDetail orddet);
	int updateOrderDetail(OrderDetail orddet);
	
	List<OrderDetail> 	getAllOrderDetail();

}
