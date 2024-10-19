package com.hexaware.techshop.ui;

import java.util.List;
import java.util.Scanner;

import com.hexaware.techshop.entity.Customer;
import com.hexaware.techshop.service.CustomerServiceImp;



public class client {
	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		boolean flag=true;
		CustomerServiceImp service = new CustomerServiceImp();
		while(flag) {
			System.out.println("***Wlecome To Ecomm***");
			System.out.println("1.Create Customer");
			System.out.println("2.Delete Customer");
			System.out.println("3.All Customer");
			System.out.println("4.Update Customer");
			System.out.println("0.EXIT");
			
			int choice=scanner.nextInt();
			switch (choice) {
			case 1:
				Customer cust=readCustData();
				
				boolean isValid = CustomerServiceImp.vaildateCst(cust);
				
				if(isValid) {
					int count =	service.createCustomer(cust);
					
					if(count>0) {
						System.out.println("Customer Added");
					}
					else{
						System.err.println("Customer Added failed");
						
					}	
					
				}
				else {
					System.err.println("Invalid Customer Data");
				}
				break;
			case 2:
				Customer custrm=new Customer();
				
				System.out.println("Enter CustomerID=");
					custrm.setCustomerID(scanner.nextInt());
					int countr=service.removeCustomer(custrm);
					
					if(countr>0) {
						System.out.println("Customer removed");
					}
					else {
						System.err.println("Customer remove failed");
					}
					
				

				break;
			case 3:
				
				List<Customer> list=service.getAllCustomer();
				System.out.println("***ALL customer**");
				for(Customer custs:list) {
					
					System.out.println(custs);
					
				}
				break;
			case 4:
				Customer custu=readCustData();
				int count =	service.updateCustomer(custu);
				
				if(count>0) {
					System.out.println("Customer updated");
				}
				else{
					System.err.println("Customer Added failed");
					
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
			public static Customer readCustData(){
				Customer cust=new Customer();
				
				System.out.println("Enter CustomerID=");
					cust.setCustomerID(scanner.nextInt());
				System.out.println("Enter Customer FirstName=");
					cust.setFirstName(scanner.next());
				System.out.println("Enter Customer Last1Name=");
					cust.setLastName(scanner.next());
				System.out.println("Enter Customer Email=");
					cust.setEmail(scanner.next());
				System.out.println("Enter Phone number=");
					cust.setPhone(scanner.next());
				System.out.println("Enter Address=");
					cust.setAddress(scanner.next());
				
				return cust;
			}
		

	}


