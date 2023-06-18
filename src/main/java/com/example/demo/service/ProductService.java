package com.example.demo.service;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Component
public class ProductService {
	
	private final ProductRepository repository;
	
	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}
	
	public void save(Product product) {
		repository.save(product);
	}
	
	public Product getProductById(Long id) {
		return repository.findById(id).get();
	}
	
	public void deleteProductById(Long id) {
		repository.deleteById(id);
	}
}
