package com.hexaware.techshop.service;

import java.util.List;

import com.hexaware.techshop.entity.Product;



public interface ProductService {
	int createPrd(Product prd);
	int removePrd(Product prd);
	int updatePrd(Product prd);
	List<Product> 	getAllProduct();

}
