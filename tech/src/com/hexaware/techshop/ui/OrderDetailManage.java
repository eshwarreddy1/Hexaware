package com.hexaware.techshop.ui;

import java.util.List;
import java.util.Scanner;

import com.hexaware.techshop.entity.OrderDetail;
import com.hexaware.techshop.service.OrderDetailServiceImp;

public class OrderDetailManage {
		static Scanner scanner=new Scanner(System.in);
		public static void main(String[] args) {
			boolean flag=true;
			OrderDetailServiceImp service = new OrderDetailServiceImp();
			while(flag) {
				System.out.println("***Wlecome To Ecomm***");
				System.out.println("1.Add OrderDetail");
				System.out.println("2.Delete OrderDetail");
				System.out.println("3.list of all OrderDetails");
				System.out.println("4.Update Orderdetails");
				System.out.println("0.EXIT");
				
				int choice=scanner.nextInt();
				switch (choice) {
				case 1: 
					OrderDetail orddet=readOrddetData(); 
					
					boolean isValid = OrderDetailServiceImp.vaildateOrderDetail(orddet);
					
					if(isValid) {
						int count =	service.createOrderDetail(orddet);
						
						if(count>0) {
							System.out.println("OrderDetail Added successfully");
						}
						else{
							System.err.println("OrderDetail Added failed");
							
						}	
						
					}
					else {
						System.err.println("Invalid Data");
					}
					break;
				case 2:
					OrderDetail orddetrm=new OrderDetail();
					
					System.out.println("Enter orderDetailID=");
						orddetrm.setOrderDetailID(scanner.nextInt());
						int countr=service.removeOrderDetail(orddetrm);
						
						if(countr>0) {
							System.out.println("OrderDetail removed");
						}
						else {
							System.err.println("OrderDeatil remove failed");
						}
						
					

					break;
				case 3:
					
					List<OrderDetail> list=service.getAllOrderDetail();
					System.out.println("***ALL OrderDetails**");
					for(OrderDetail orddetlist:list) {
						
						System.out.println(orddetlist);
						
					}
					break;
//				case 4:
//					Customer custu=readData();
//					int count =	service.updateCustomer(custu);
//					
//					if(count>0) {
//						System.out.println("Customer updated");
//					}
//					else{
//						System.err.println("Customer Added failed");
//						
//					}	
//					break;
//					
				case 0:
					System.out.println("*****Exit******");
					break;

				default:
					System.out.println("Invaild Choice");
					break;
					
				}	
	}
	}
				public static OrderDetail readOrddetData(){
					OrderDetail orddet=new OrderDetail();
					
					System.out.println("Enter orderDetailID=");
						orddet.setOrderDetailID(scanner.nextInt());
					System.out.println("Enter orderID=");
						orddet.setOrderID(scanner.nextInt());
					System.out.println("Enter ProductID=");
						orddet.setProduct(scanner.nextInt());
					System.out.println("Enter of Quantity=");
						orddet.setQuantity(scanner.nextInt());
						
					return orddet;
				}

}

