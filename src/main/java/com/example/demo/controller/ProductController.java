package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping("/add")
	public void addProduct(@RequestBody Product product) {
		System.out.println("Add product called! Saving product data in the database!");
		System.out.println("production.name: " + product.getName());
		productService.save(product);
	}

	@GetMapping("/get/{id}")
	public Product getProduct(@PathVariable Long id) {
		System.out.println("Get product called with id: " + id);
		return productService.getProductById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productService.deleteProductById(id);
		return "Successfully deleted the product of id: "+id;
	}
	
}
