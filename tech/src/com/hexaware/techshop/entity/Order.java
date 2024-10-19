package com.hexaware.techshop.entity;

import java.sql.Date;

public class Order {
	private int orderID;
    private int customerID;
    private String orderDate;
    private double totalAmount;
    private String orderStatus;
	public Order() {
		super();
	}
	public Order(int orderID, int customerID, String orderDate, double totalAmount, String orderStatus) {
		super();
		this.orderID = orderID;
		this.customerID = customerID;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.orderStatus = orderStatus;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public double getTotalAmount() {
		return totalAmount;   
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", customerID=" + customerID + ", orderDate=" + orderDate
				+ ", totalAmount=" + totalAmount + ", orderStatus=" + orderStatus + "]";
	}



    
    
}