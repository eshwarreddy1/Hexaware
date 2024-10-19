package com.hexaware.techshop.service;

import java.util.List;

import com.hexaware.techshop.entity.Inventory;

public interface Inventoryservice {
	int createInventory(Inventory inv);
	int removeInventory(Inventory inv);
	int updateInventory(Inventory inv);
	
	List<Inventory> 	getAllInventory();

}
