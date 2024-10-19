package com.hexaware.techshop.ui;

import java.util.List;
import java.util.Scanner;

import com.hexaware.techshop.entity.Order;
import com.hexaware.techshop.service.OrderServiceImp;

public class OrderManage {	
		static Scanner scanner=new Scanner(System.in);
		public static void main(String[] args) {
			boolean flag=true;
			OrderServiceImp service = new OrderServiceImp();
			while(flag) {
				System.out.println("***Wlecome To Ecomm***");
				System.out.println("1.Create Order");
				System.out.println("2.Delete Order");
				System.out.println("3.List of ALL Orders");
				System.out.println("4.Update OrderStatus");
				System.out.println("0.EXIT");
				
				int choice=scanner.nextInt();
				switch (choice) {
				case 1: 
					Order ord=readOrdData(); 
					
					boolean isValid = OrderServiceImp.vaildateOrd(ord);
					
					if(isValid) {
						int count =	service.createOrder(ord);
						
						if(count>0) {
							System.out.println("Order placed");
						}
						else{
							System.err.println("Order not placed");
							
						}	
						
					}
					else {
						System.err.println("Invalid Data");
					}
					break;
				case 2:
					Order ordrm=new Order();
					
					System.out.println("Enter orderID=");
						ordrm.setOrderID(scanner.nextInt());
						int countr=service.removeOrder(ordrm);
						
						if(countr>0) {
							System.out.println("order cancelled");
						}
						else {
							System.err.println("order not cancelled");
						}
						
					break;
				case 3:
					
					List<Order> list=service.getAllOrder();
					System.out.println("***ALL Order**");
					for(Order ords:list) {
						
						System.out.println(ords);
						
					}
					break;
				case 4:
					Order ordu=new Order();
					System.out.println("Enter orderID=");
						ordu.setOrderID(scanner.nextInt());
					System.out.println("Enter CustomerID=");
						ordu.setCustomerID(scanner.nextInt());
					System.out.println("Enter the orderstatus=");
						ordu.setOrderStatus(scanner.next());
					int count =	service.updateOrder(ordu);
					
					if(count>0) {
						System.out.println("OrderStatus  updated");
					}
					else{
						System.err.println("update failed");
						
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
				public static Order readOrdData(){
					Order ord=new Order();
					
					System.out.println("Enter orderID=");
						ord.setOrderID(scanner.nextInt());
					System.out.println("Enter CustomerID=");
						ord.setCustomerID(scanner.nextInt());
					System.out.println("Enter order date(yyyy-mm-dd)=");
						ord.setOrderDate(scanner.next());
					System.out.println("Enter of TotalAmount");
						ord.setTotalAmount(scanner.nextDouble());
					System.out.println("Enter the orderstatus=");
						ord.setOrderStatus(scanner.next());
					
					return ord;
				}

}
