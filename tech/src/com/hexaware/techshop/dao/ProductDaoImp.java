package com.hexaware.techshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.techshop.entity.Customer;
import com.hexaware.techshop.entity.Product;


public class ProductDaoImp implements ProductDao {
	private Connection conn;
	public ProductDaoImp() {
		
		conn=DBUtil.getDBConnection();
	
	}
	
	@Override
	public int createPrd(Product prd) {
		int count=0;
		
		String insert="insert into Product(productID,productName,description,price) values(?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(insert);
			
			pstmt.setInt(1, prd.getProductID());
			pstmt.setString(2, prd.getProductName());
			pstmt.setString(3, prd.getDescription());
			pstmt.setDouble(4, prd.getPrice());
			
			count=pstmt.executeUpdate();
			
			return count;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int removePrd(Product prd) {
		int count=0;
		
		String delete="delete from Product where productId=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(delete);
			
			pstmt.setInt(1, prd.getProductID());
			
			count=pstmt.executeUpdate();
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int updatePrd(Product prod) {
			int count=0;
		
		String updateQuery="update Product set productname=?,description=?,price=? where productID=?";
		
		try {
			PreparedStatement pstmt=conn.prepareStatement(updateQuery);
		
			
			pstmt.setString(1, prod.getProductName());
			pstmt.setString(2, prod.getDescription());
			pstmt.setDouble(3, prod.getPrice());
			pstmt.setInt(4, prod.getProductID());
			
			
			count=pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public List<Product> getAllProduct() {
	List<Product> list=new ArrayList<Product>();
		
		String selectAll="select *from product";
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectAll);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				int productID=rs.getInt("productID");
				String productName=rs.getString("ProductName");
				String description=rs.getString("description");
				double price=rs.getDouble("price");
				
				Product prod=new Product(productID,productName,description,price);
				list.add(prod);
				
			}} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
		}
	}
