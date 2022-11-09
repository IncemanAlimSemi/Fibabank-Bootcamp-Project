package com.example.demo.dto;

import java.util.List;

import com.example.demo.entity.CartProduct;

public class CartDto {

	private long cartId;
	
	private String customerName;
	
	private double totalAmount;
	
	private List<CartProductDto> cartProductsDto;

	public CartDto() {}
	

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public List<CartProductDto> getCartProducts() {
		return cartProductsDto;
	}

	public void setCartProducts(List<CartProductDto> cartProductsDto) {
		this.cartProductsDto = cartProductsDto;
	}

}
