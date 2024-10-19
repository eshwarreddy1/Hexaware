package com.hexaware.techshop.entity;



public class Inventory {
	private int inventoryID;
    private int productID;
    private int quantityInStock;
    private String lastStockUpdate;
	public Inventory() {
		super();
	}
	public Inventory(int inventoryID, int productID, int quantityInStock, String lastStockUpdate) {
		super();
		this.inventoryID = inventoryID;
		this.productID = productID;
		this.quantityInStock = quantityInStock;
		this.lastStockUpdate = lastStockUpdate;
	}
	public int getInventoryID() {
		return inventoryID;
	}
	public void setInventoryID(int inventoryID) {
		this.inventoryID = inventoryID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	public String getLastStockUpdate() {
		return lastStockUpdate;
	}
	public void setLastStockUpdate(String lastStockUpdate) {
		this.lastStockUpdate = lastStockUpdate;
	}
	@Override
	public String toString() {
		return "Inventory [inventoryID=" + inventoryID + ", productID=" + productID + ", quantityInStock="
				+ quantityInStock + ", lastStockUpdate=" + lastStockUpdate + "]";
	}

    
}
