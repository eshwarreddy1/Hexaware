package com.hexaware.techshop.service;


import java.util.List;

import com.hexaware.techshop.dao.CustomerDao;
import com.hexaware.techshop.dao.CustomerDaoImp;
import com.hexaware.techshop.entity.Customer;

public class CustomerServiceImp implements CustomerSrevice {
	private	CustomerDao dao;
	public CustomerServiceImp() {
		dao=new CustomerDaoImp();
	}
	@Override
	public int createCustomer(Customer cust) {
		
		return dao.createCustomer(cust);
	}
	
	@Override
	public int removeCustomer(Customer cust) {
		
		return dao.removeCustomer(cust);
	}
	@Override
	public int updateCustomer(Customer cust) {
	
		return dao.updateCustomer(cust);
	}
	@Override
	public List<Customer> getAllCustomer() {
		
		return dao.getAllCustomer();
	}
	
	public static boolean vaildateCst(Customer cust) {
		
		
		boolean flag=false;
		String emailval= "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		if(cust.getCustomerID()>100 && cust.getFirstName().length()>5 && cust.getLastName().length()>3 && cust.getEmail().matches(emailval) && cust.getPhone().length()>9 && cust.getAddress().length()>5) {
			
			flag=true;
		}
		return flag;


}
	
	
	

}