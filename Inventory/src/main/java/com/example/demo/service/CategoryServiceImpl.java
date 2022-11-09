package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	private CategoryRepository categoryRepository;
	public  CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<CategoryDto> findAll() {
		List<CategoryDto> categoryDtos = new ArrayList<>();
		Iterable<Category> categories = categoryRepository.findAll();
		for (Category category : categories) {
			CategoryDto categoryDto = new CategoryDto();
			categoryDto.setCategoryId(category.getCategoryId());
			categoryDto.setCategoryName(category.getCategoryName());
			
			List<ProductDto> productDtos = new ArrayList<>();
			List<Product> products = category.getProductList();
			
			for (Product product : products) {
				ProductDto productDto = new ProductDto();
				productDto.setProductId(product.getProductId());
				productDto.setProductName(product.getProductName());
				productDto.setSalesPrice(product.getSalesPrice());
				productDtos.add(productDto);
			}
			
			categoryDto.setProductDtoList(productDtos);
			categoryDtos.add(categoryDto);
		}
		return categoryDtos;
	}
	
}
