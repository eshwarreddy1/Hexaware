package com.hexaware.techshop.dao;

import java.util.List;

import com.hexaware.techshop.entity.Customer;

public interface CustomerDao {
	int createCustomer(Customer cust);
	int removeCustomer(Customer cust);
	int updateCustomer(Customer cust);
	List<Customer> getAllCustomer();
	
}
