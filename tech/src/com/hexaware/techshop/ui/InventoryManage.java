package com.hexaware.techshop.ui;

import java.util.List;
import java.util.Scanner;

import com.hexaware.techshop.entity.Inventory;
import com.hexaware.techshop.service.InventoryServiceImp;


public class InventoryManage {
	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		
		boolean flag=true;
		InventoryServiceImp service = new InventoryServiceImp();
		while(flag) {
			System.out.println("***Wlecome To Ecomm***");
			System.out.println("1.Create Inventory");
			System.out.println("2.Delete Inventory");
			System.out.println("3.list of Inventory");
			System.out.println("4.Update Product");
			System.out.println("0.EXIT");
			
			int choice=scanner.nextInt();
		switch (choice) {
		case 1:
			Inventory inv=readInvData();

			boolean isValid=InventoryServiceImp.vaildateInv(inv);
			
			if(isValid) {
			int count=	service.createInventory(inv);
			
				if(count>0) {
					System.out.println("Product Added");
				}
				else{
					System.err.println("Product Add failed");
					
				}
			}
			else {
				System.err.println("Invalid date input");
			}
			
			
			break;
		case 2:
			Inventory invr=new Inventory();
			
			System.out.print("Enter InventoryId=");
				invr.setInventoryID(scanner.nextInt());
				int countr=service.removeInventory(invr);
				
				if(countr>0) {
					System.out.println("Delete the record Successfully");
				}
				else {
					System.err.println("Delete record failed");
				}

			break;
		case 3:
			
			List<Inventory> list=service.getAllInventory();
			System.out.println("***Inventory List**");
			for(Inventory invs:list) {	
				System.out.println(invs);	
			}
			break;
		case 4:
			Inventory invu=readInvData();
			int count =	service.updateInventory(invu);
			
			if(count>0) {
				System.out.println("Stock updated");
			}
			else{
				System.err.println("updated failed");
				
			}	
			break;
		case 0:
			System.out.println("*****Exit******");
			break;

		default:
			System.out.println("Invaild Choice");
			break;
		}
	}
	}
	public static Inventory readInvData(){
		Inventory inv=new Inventory();
		System.out.print("Enter InventoryID=");
			inv.setInventoryID(scanner.nextInt());
		System.out.print("Enter ProductID=");
			inv.setProductID(scanner.nextInt());
		System.out.print("Enter the QuantityInStock=");
			inv.setQuantityInStock(scanner.nextInt());
		System.out.println("Enter the laststockupdate date(yyyy-mm-dd=)");
			inv.setLastStockUpdate(scanner.next());
		
		return inv;
	}
}
