package com.hexaware.techshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.techshop.entity.Customer;

public class CustomerDaoImp implements CustomerDao {
	private Connection conn;
	public CustomerDaoImp() {
		
		conn=DBUtil.getDBConnection();
	
	}
	@Override
	public int createCustomer(Customer cust) {
		int count=0;
		
		String insert="insert into Customer(customerID,firstname,lastname,email,phone,address) values(?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(insert);
		
			pstmt.setInt(1, cust.getCustomerID());
			pstmt.setString(2, cust.getFirstName());
			pstmt.setString(3, cust.getLastName());
			pstmt.setString(4, cust.getEmail());
			pstmt.setString(5, cust.getPhone());
			pstmt.setString(6, cust.getAddress());
			
			
			count=pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public int removeCustomer(Customer cust) {
		int count=0;
		
		String delete="delete from Customer where customerId=?";
		
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, cust.getCustomerID());
			
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return count;
	}
	@Override
	public int updateCustomer(Customer cust) {
			int count=0;
		
		String updateQuery="update Customer set firstname=?,lastname=?,email=?,phone=?,address=? where CustomerID=?";
		
		try {
			PreparedStatement pstmt=conn.prepareStatement(updateQuery);
		
			
			pstmt.setString(1, cust.getFirstName());
			pstmt.setString(2, cust.getLastName());
			pstmt.setString(3, cust.getEmail());
			pstmt.setString(4, cust.getPhone());
			pstmt.setString(5, cust.getAddress());
			pstmt.setInt(6, cust.getCustomerID());
			
			
			count=pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> list=new ArrayList<Customer>();
		
		String selectAll="select *from customer";
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectAll);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				int customerID=rs.getInt("customerID");
				String firstName=rs.getString("FirstName");
				String lastName=rs.getString("LastName");
				String email=rs.getString("email");
				String phone=rs.getString("phone");
				String address=rs.getString("address");
				
				Customer cust=new Customer(customerID,firstName,lastName,email,phone,address);
				list.add(cust);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	

}
