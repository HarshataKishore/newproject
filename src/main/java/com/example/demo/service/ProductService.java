package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	public List<Product> getAllProduct()   
	{  
	List<Product> product = new ArrayList<Product>();  
	productRepository.findAll().forEach(product1 -> product.add(product1));  
	return product;  
	}  
	public Product getProductById(int id)   
	{  
	return productRepository.findById(id).get();  
	}  
	public void saveOrUpdate(Product product)   
	{  
	productRepository.save(product);  
	}  
	public void delete(int id)   
	{  
	productRepository.deleteById(id);  
	}  
	public void update(Product product, int productid)   
	{  
		productRepository.save(product);  
	}  
	

}
