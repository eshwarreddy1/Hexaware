package com.hexaware.techshop.dao;

import java.util.List;

import com.hexaware.techshop.entity.Inventory;


public interface InventoryDao {
	int createInventory(Inventory inv);
	int removeInventory(Inventory inv);
	int updateInventory(Inventory inv);
	
	List<Inventory> 	getAllInventory();

}
