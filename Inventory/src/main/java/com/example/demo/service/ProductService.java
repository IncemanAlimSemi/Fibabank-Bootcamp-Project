package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ProductDto;


public interface ProductService {
	
	List<ProductDto> findByCategoryId(long categoryId);
	ProductDto findByProductId(long productId);
	
}
