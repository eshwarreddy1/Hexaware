package com.hexaware.techshop.dao;

import java.util.List;

import com.hexaware.techshop.entity.Product;



public interface ProductDao {
	int createPrd(Product prd);
	int removePrd(Product prd);
	int updatePrd(Product prd);
	List<Product> 	getAllProduct();

}
