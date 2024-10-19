package com.hexaware.techshop.service;

import java.util.List;

import com.hexaware.techshop.dao.OrderDetailDao;
import com.hexaware.techshop.dao.OrderDetailDaoImp;
import com.hexaware.techshop.entity.OrderDetail;

public class OrderDetailServiceImp implements OrderDetailService {
	private	OrderDetailDao dao;
	public OrderDetailServiceImp() {
		dao=new OrderDetailDaoImp();
	}
	@Override
	public int createOrderDetail(OrderDetail orddet) {
		
		return dao.createOrderDetail(orddet);
	}

	@Override
	public int removeOrderDetail(OrderDetail orddet) {
		// TODO Auto-generated method stub
		return dao.removeOrderDetail(orddet);
	}

	@Override
	public List<OrderDetail> getAllOrderDetail() {
	
		return dao.getAllOrderDetail();
	}
	public static boolean vaildateOrderDetail(OrderDetail orddet) {
		
		
		boolean flag=false;
		if(orddet.getOrderDetailID()>120 && orddet.getQuantity()>0) {
			
			flag=true;
		}
		return flag;}

}
