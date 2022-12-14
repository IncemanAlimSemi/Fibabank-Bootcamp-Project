package com.example.demo.dto;

import java.util.List;


public class CategoryDto {

	private long categoryId;
	
	private String categoryName;
	
	private List<ProductDto> productDtoList;
	
	public CategoryDto() {}

	public CategoryDto(long categoryId, String categoryName) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<ProductDto> getProductDtoList() {
		return productDtoList;
	}

	public void setProductDtoList(List<ProductDto> productDtoList) {
		this.productDtoList = productDtoList;
	}	
}
