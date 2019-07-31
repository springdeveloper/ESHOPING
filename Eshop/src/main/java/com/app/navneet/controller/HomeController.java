package com.app.navneet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.navneet.aspect.LogExecutionTime;
import com.app.navneet.model.Product;
import com.app.navneet.service.ProductService;

@RestController
public class HomeController {

	@Autowired
	ProductService productService;

	@GetMapping("/add")
	public ResponseEntity<Product> getData() {
		Product pr = new Product("Apple", 123.45);
		return new ResponseEntity<Product>(productService.add(pr), HttpStatus.OK);
	}

	@GetMapping("/list")
	@LogExecutionTime
	public ResponseEntity<List<Product>> getProductList() {
		return new ResponseEntity<List<Product>>(productService.getProductList(), HttpStatus.OK);
	}

}
