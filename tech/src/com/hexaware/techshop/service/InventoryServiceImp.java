package com.hexaware.techshop.service;

import java.util.List;

import com.hexaware.techshop.dao.InventoryDao;
import com.hexaware.techshop.dao.InventoryDaoImp;
import com.hexaware.techshop.entity.Inventory;


public class InventoryServiceImp implements Inventoryservice {
	private	InventoryDao dao;
	public InventoryServiceImp() {
		dao=new InventoryDaoImp();
	}
	@Override
	public int createInventory(Inventory inv) {
		// TODO Auto-generated method stub
		return dao.createInventory(inv);
	}

	@Override
	public int removeInventory(Inventory inv) {
		// TODO Auto-generated method stub
		return dao.removeInventory(inv);
	}

	@Override
	public int updateInventory(Inventory inv) {
		// TODO Auto-generated method stub
		return dao.updateInventory(inv);
	}

	@Override
	public List<Inventory> getAllInventory() {
		// TODO Auto-generated method stub
		return dao.getAllInventory();
	}
	public static boolean vaildateInv(Inventory inv) {
		
		
		boolean flag=false;
		String date= "^(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";

		if(inv.getInventoryID()>200 && inv.getQuantityInStock()>0 &&inv.getLastStockUpdate().matches(date)) {
			
			flag=true;
		}
		return flag;
}

}
