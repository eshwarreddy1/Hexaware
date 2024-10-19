package com.hexaware.techshop.service;

import java.util.List;

import com.hexaware.techshop.entity.Customer;

public interface CustomerSrevice {
	int createCustomer(Customer cust);
	int removeCustomer(Customer cust);
	int updateCustomer(Customer cust);
	
	List<Customer> 	getAllCustomer();
	
	
	

}
