package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.service.ProductService;
import com.example.demo.model.Product;

@RestController  
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping("/products")  
	private List<Product> getAllProduct()   
	{  
	return productService.getAllProduct();  
	}  

	@GetMapping("/products/{productid}")  
	private Product getProduct(@PathVariable("productid") int productid)   
	{  
	return productService.getProductById(productid);  
	}  

	@DeleteMapping("/products/{productid}")  
	private void deleteProduct(@PathVariable("productid") int productid)   
	{  
	productService.delete(productid);  
	}  

	@PostMapping("/products")  
	private int saveProduct(@RequestBody Product products)   
	{  
	productService.saveOrUpdate(products);  
	return products.getProductid();  
	}  
	@PutMapping("/products")  
	private Product update(@RequestBody Product product)   
	{  
	productService.saveOrUpdate(product);  
	return product;  
	}  
	
}
