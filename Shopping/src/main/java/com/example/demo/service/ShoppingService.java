package com.example.demo.service;

import com.example.demo.dto.AddDto;
import com.example.demo.dto.CartDto;

public interface ShoppingService {

	long createCart(String customerName);
	
	void addCart(AddDto addDto);
	
	void deleteProductFromCartProduct(long cartId, long productId);
	
	void checkout(long cartId);
	
	CartDto find(long cartId);
	
}
