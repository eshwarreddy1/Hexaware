package com.hexaware.techshop.service;

import java.util.List;

import com.hexaware.techshop.dao.OrderDao;
import com.hexaware.techshop.dao.OrderDaoImp;
import com.hexaware.techshop.entity.Order;

public class OrderServiceImp implements OrderService {
	private	OrderDao dao;
	public OrderServiceImp() {
		dao=new OrderDaoImp();
	}
	@Override
	public int createOrder(Order ord) {
		
		return dao.createOrder(ord);
	}

	@Override 
	public int removeOrder(Order ord) {
		
		return dao.removeOrder(ord);
	}

	@Override
	public int updateOrder(Order ord) {
		// TODO Auto-generated method stub
		return dao.updateOrder(ord);
	}

	@Override
	public List<Order> getAllOrder() {
		
		return dao.getAllOrder();
	}
	public static boolean vaildateOrd(Order ord) {
		
		
		boolean flag=false;
		String date= "^(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
		if(ord.getOrderID()>120 && ord.getOrderDate().matches(date)) {
			
			flag=true;
		}
		return flag;
}}
