package com.app.navneet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.navneet.aspect.PrintLogOn;
import com.app.navneet.model.Product;
import com.app.navneet.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
  
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	@PrintLogOn
	public Product add(Product p) {

		return productRepository.save(p);
	}

	@Override
	public List<Product> getProductList() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

}
