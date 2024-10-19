package com.hexaware.techshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.hexaware.techshop.entity.OrderDetail;

public class OrderDetailDaoImp implements OrderDetailDao {
	private Connection conn;
	public OrderDetailDaoImp() {
		
		conn=DBUtil.getDBConnection();
	
	}
	@Override
	public int createOrderDetail(OrderDetail orddet) {
		int count=0;
		
		String insert="insert into OrderDetail(orderDetailID,orderID,productID,quantity) values(?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(insert);
		
			pstmt.setInt(1, orddet.getOrderDetailID());
			pstmt.setInt(2, orddet.getOrderID());
			pstmt.setInt(3, orddet.getProductID());
			pstmt.setInt(4, orddet.getQuantity());

			
			
			count=pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int removeOrderDetail(OrderDetail orddet) {
		int count=0;
		
		String delete="delete from orderdetail where orderDetailID=?";
		
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, orddet.getOrderDetailID());
			
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return count;
	}

	@Override
	public int updateOrderDetail(OrderDetail orddet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<OrderDetail> getAllOrderDetail() {
		List<OrderDetail> list=new ArrayList<OrderDetail>();
		
		String selectAll="select *from orderdetail";
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectAll);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				int orderDetailID=rs.getInt("orderDetailID");
				int orderID=rs.getInt("orderID");
				int productID=rs.getInt("productID");
				int quantity=rs.getInt("Quantity");
				
				OrderDetail orddet=new OrderDetail(orderDetailID,orderID,productID, quantity);
				list.add(orddet);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	}


