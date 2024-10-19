package com.hexaware.techshop.ui;

import java.util.Scanner;

import com.hexaware.techshop.service.CustomerServiceImp;
import com.hexaware.techshop.service.InventoryServiceImp;
import com.hexaware.techshop.service.OrderDetailServiceImp;
import com.hexaware.techshop.service.OrderServiceImp;
import com.hexaware.techshop.service.ProductServiceImp;

public class MainMenu {
	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		boolean flag=true;
		CustomerServiceImp cservice = new CustomerServiceImp();
		ProductServiceImp pservice = new ProductServiceImp();
		OrderServiceImp oservice = new OrderServiceImp();
		OrderDetailServiceImp odservice = new OrderDetailServiceImp();
		InventoryServiceImp iservice = new InventoryServiceImp();
		while(flag) {
			System.out.println("***Wlecome To Ecomm***");
			System.out.println("1.Customer Registation");
			System.out.println("2.Delete Customer");
			System.out.println("3.All Customer");
			System.out.println("4.Update Customer");
			System.out.println("0.EXIT");
			
			int choice=scanner.nextInt();
			
		
		}
	

	}

}
