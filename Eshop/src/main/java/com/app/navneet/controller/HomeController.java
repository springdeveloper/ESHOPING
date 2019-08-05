package com.app.navneet.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.navneet.aspect.LogExecutionTime;
import com.app.navneet.aspect.PrintLogOn;
import com.app.navneet.dto.ProductDto;
import com.app.navneet.model.Product;
import com.app.navneet.service.ProductService;
import com.app.navneet.utils.ConvertUtils;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "http://localhost:4200")
public class HomeController {

	@Autowired
	ProductService productService;

    @RequestMapping(value = "/add", method = RequestMethod.POST,    consumes = {"multipart/form-data"})
	@LogExecutionTime
	@PrintLogOn
	public @ResponseBody ResponseEntity<Product> addProduct(@RequestPart(value="file") MultipartFile productImage,@RequestPart("product") ProductDto product) throws JsonParseException, JsonMappingException, IOException {
	                 
		return new ResponseEntity<Product>(productService.add(ConvertUtils.convertDtoProduct(product, productImage)), HttpStatus.CREATED);
	}

   
	
	@GetMapping("/list")
	@LogExecutionTime
	public ResponseEntity<List<Product>> getProductList() {
		return new ResponseEntity<List<Product>>(productService.getProductList(), HttpStatus.OK);
	}

	@GetMapping("/delete/{id}")
	@LogExecutionTime
	@PrintLogOn
	public ResponseEntity<?> deleteByID(@PathVariable("id") Long id) {
		System.out.println("Delete");
		return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.ACCEPTED);
	}

	@GetMapping("/edit/{id}")
	@LogExecutionTime
	@PrintLogOn
	public ResponseEntity<?> editByID(@PathVariable("id") Long id) {
		System.out.println("Edite");
		return new ResponseEntity<>(productService.editProduct(id), HttpStatus.ACCEPTED);
	}

	

}
