package com.example.demo.dto;

public class CartProductDto {

	private long cartProductId;
	
	private long productId;
	
	private String productName; 
	
	private int salesQuantity;
	
	private double salesPrice;
	
	private double lineAmount;
	
	public CartProductDto() {}

	public CartProductDto(long cartProductId, long productId, String productName, int salesQuantity, double salesPrice,
			double lineAmount) {
		this.cartProductId = cartProductId;
		this.productId = productId;
		this.productName = productName;
		this.salesQuantity = salesQuantity;
		this.salesPrice = salesPrice;
		this.lineAmount = lineAmount;
	}

	public long getCartProductId() {
		return cartProductId;
	}

	public void setCartProductId(long cartProductId) {
		this.cartProductId = cartProductId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public int getSalesQuantity() {
		return salesQuantity;
	}

	public void setSalesQuantity(int salesQuantity) {
		this.salesQuantity = salesQuantity;
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public double getLineAmount() {
		return lineAmount;
	}

	public void setLineAmount(double lineAmount) {
		this.lineAmount = lineAmount;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}