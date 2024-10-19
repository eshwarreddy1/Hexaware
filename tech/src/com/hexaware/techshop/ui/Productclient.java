package com.hexaware.techshop.ui;

import java.util.List;
import java.util.Scanner;


import com.hexaware.techshop.entity.Product;
import com.hexaware.techshop.service.ProductServiceImp;



public class Productclient {

	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		
		boolean flag=true;
		ProductServiceImp service = new ProductServiceImp();
		while(flag) {
			System.out.println("***Wlecome To Ecomm***");
			System.out.println("1.Create Product");
			System.out.println("2.Delete Product");
			System.out.println("3.All Product");
			System.out.println("4.Update Product");
			System.out.println("0.EXIT");
			
			int choice=scanner.nextInt();
		switch (choice) {
		case 1:
			Product prd=readPrdData();

			boolean isValid=ProductServiceImp.vaildatePrd(prd);
			
			if(isValid) {
			int count=	service.createPrd(prd);
			
				if(count>0) {
					System.out.println("Product Added Successfully");
				}
				else{
					System.err.println("Product Add failed");
					
				}
			}
			else {
				System.err.println("Invalid Input");
			}
			
			
			break;
		case 2:
			Product prdr=new Product();
			
			System.out.print("Enter ProductId=");
				prdr.setProductID(scanner.nextInt());
				int countr=service.removePrd(prdr);
				
				if(countr>0) {
					System.out.println("Product removed Successfully");
				}
				else {
					System.err.println("Product remove failed");
				}

			break;
		case 3:
			
			List<Product> list=service.getAllProduct();
			System.out.println("***ALL customer**");
			for(Product prods:list) {	
				System.out.println(prods);	
			}
		case 4:
			Product produ=readPrdData();
			int count =	service.updatePrd(produ);
			
			if(count>0) {
				System.out.println("Product updated successfully");
			}
			else{
				System.err.println("Product updated failed");
				
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
	public static Product readPrdData(){
		Product prod=new Product();
		System.out.print("Enter ProductID=");
			prod.setProductID(scanner.nextInt());
		System.out.print("Enter Product Name=");
			prod.setProductName(scanner.next());
		System.out.print("Enter the Product Description=");
			prod.setDescription(scanner.next());
		System.out.print("Enter Product Price=");
			prod.setPrice(scanner.nextDouble());
	
		return prod;
	}	
}
