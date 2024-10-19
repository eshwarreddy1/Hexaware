package com.hexaware.techshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.techshop.entity.Order;

public class OrderDaoImp implements OrderDao {
	private Connection conn;
	public OrderDaoImp() {
		
		conn=DBUtil.getDBConnection();
	
	}

	@Override
	public int createOrder(Order ord) {
		int count=0;
		
		String insert="insert into Orders(orderID,customerID,orderDate,totalAmount,orderStatus) values(?,?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(insert);
		
			pstmt.setInt(1, ord.getOrderID());
			pstmt.setInt(2, ord.getCustomerID());
			pstmt.setString(3, ord.getOrderDate());
			pstmt.setDouble(4, ord.getTotalAmount());
			pstmt.setString(5, ord.getOrderStatus());
			
			
			count=pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int removeOrder(Order ord) {
		int count=0;
		
		String delete="delete from orders where orderID=?";
		
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, ord.getOrderID());
			
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return count;
	}

	@Override
	public int updateOrder(Order ord) {
		int count=0;
		
		String update="update Orders set orderStatus=? where orderID=? and customerID=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(update);
			
			pstmt.setString(1, ord.getOrderStatus());
			pstmt.setInt(2, ord.getOrderID());
			pstmt.setInt(3, ord.getCustomerID());
//			pstmt.setDate(3, ord.getOrderDate());
			
			
			
			count=pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Order> getAllOrder() {
		List<Order> list=new ArrayList<Order>();
		
		String selectAll="select *from orders";
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectAll);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				int orderID=rs.getInt("orderID");
				int customerID=rs.getInt("customerID");
				String orderDate=rs.getString("orderDate");
				double totalAmount=rs.getDouble("totalAmount");
				String orderStatus=rs.getString("orderStatus");
				
				Order ord=new Order(orderID,customerID,orderDate,totalAmount,orderStatus);
				list.add(ord);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
