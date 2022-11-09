package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AddDto;
import com.example.demo.dto.CartDto;
import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.ProductDto;


public interface CommerceService {
	
	List<CategoryDto> findAll();

	List<ProductDto> findByCategoryId(long categoryId);
	
	ProductDto findByProductId(long productId);
	
	long createCart(String customerName);
	
	void addCart(AddDto addDto);
	
	void deleteProductFromCartProduct(long cartId, long productId);
	
	void checkout(long cartId);
	
	CartDto find(long cartId);
}
