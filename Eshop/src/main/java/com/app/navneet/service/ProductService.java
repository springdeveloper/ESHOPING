package com.app.navneet.service;

import java.util.List;

import com.app.navneet.model.Product;

public interface ProductService {
	
	public Product add(Product p);
	public List<Product> getProductList();
	public boolean deleteProduct(Long id);
	public Product editProduct(Long id);


}
