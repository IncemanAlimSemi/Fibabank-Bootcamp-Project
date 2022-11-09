package com.example.demo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CategoryDto;
import com.example.demo.service.CategoryService;

@RestController
public class CategoryResource {
	
	private CategoryService categoryService;
	
	public CategoryResource(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping("/api/categories")
	public List<CategoryDto> getCategories() {
		List<CategoryDto> categoryDtos = categoryService.findAll();
		return categoryDtos;
	}
}
