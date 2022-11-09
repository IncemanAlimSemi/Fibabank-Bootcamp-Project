package com.example.demo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductDto;
import com.example.demo.service.ProductService;

@RestController
public class ProductResource {
	
	private ProductService productService;
	
	public ProductResource(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/api/products/{categoryId}")
	public List<ProductDto> getProducts(@PathVariable("categoryId") long categoryId) {
		List<ProductDto> productDtos = productService.findByCategoryId(categoryId);
		return productDtos;
	}
	
	@GetMapping("/api/product/{productId}")
	public ProductDto getProduct(@PathVariable("productId") long productId) {
		ProductDto productDto = productService.findByProductId(productId);
		return productDto;
	}
	
}
