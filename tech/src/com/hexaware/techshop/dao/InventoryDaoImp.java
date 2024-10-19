package com.hexaware.techshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.techshop.entity.Inventory;
import com.hexaware.techshop.entity.Order;

public class InventoryDaoImp implements InventoryDao {
	private Connection conn;
	public InventoryDaoImp() {
		
		conn=DBUtil.getDBConnection();
	
	}
	@Override
	public int createInventory(Inventory inv) {
		int count=0;
		
		String insert="insert into Inventory(inventoryID,productID,quantityInStock,lastStockUpdate) values(?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(insert);
		
			pstmt.setInt(1, inv.getInventoryID());
			pstmt.setInt(2, inv.getProductID());
			pstmt.setDouble(3, inv.getQuantityInStock());
			pstmt.setString(4, inv.getLastStockUpdate());
			
			
			count=pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int removeInventory(Inventory inv) {
		int count=0;
		
		String delete="delete from inventory where inventoryID=?";
		
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, inv.getInventoryID());
			
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return count;
	}

	@Override
	public int updateInventory(Inventory inv) {
		int count=0;
		
		String update="update Inventory set quantityInStock=? where productID=? and inventoryID=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(update);
		
			pstmt.setDouble(1, inv.getQuantityInStock());
			pstmt.setInt(2, inv.getProductID());
			pstmt.setInt(3, inv.getInventoryID());
			
			
			count=pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Inventory> getAllInventory() {
		List<Inventory> list=new ArrayList<Inventory>();
		
		String selectAll="select *from inventory";
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectAll);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				int inventoryID=rs.getInt("inventoryID");
				int productID=rs.getInt("productID");
				int quantityInStock=rs.getInt("quantityinstock");
				String lastStackUpdate=rs.getString("lastStackUpdate");
				
				Inventory inv=new Inventory(inventoryID,productID,quantityInStock,lastStackUpdate);
				list.add(inv);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
