package com.hexaware.techshop.service;

import java.util.List;

import com.hexaware.techshop.dao.ProductDao;
import com.hexaware.techshop.dao.ProductDaoImp;
import com.hexaware.techshop.entity.Product;



public class ProductServiceImp implements ProductService {

	private	ProductDao dao;
	public ProductServiceImp() {
		dao=new ProductDaoImp();
	}
	@Override
	public int createPrd(Product prd) {
		
		return dao.createPrd(prd);
	}
	@Override
	public int removePrd(Product prd) {
		
		return dao.removePrd(prd);
	}

	@Override
	public List<Product> getAllProduct() {
		return dao.getAllProduct();
	}
	
	public static boolean vaildatePrd(Product prd) {
		
		
		boolean flag=false;
		if(prd.getProductID()>120 && prd.getProductName().length()>5 && prd.getPrice()>1000) {
			
			flag=true;
		}
		return flag;
	}
	@Override
	public int updatePrd(Product prd) {
		return dao.updatePrd(prd);
	}
}
