package com.example.demo.client;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.CategoryDto;

@Controller
@RequestMapping("/inventory")
public class CategoryClient {

	@GetMapping("/categories")
	@ResponseBody
	public List<CategoryDto> getCategories() {
		String url = "http://localhost:8081/api/categories";
		RestTemplate restTemplate = new RestTemplate();
		List<CategoryDto> categoryDtos = restTemplate.getForObject(url, List.class);
		return categoryDtos;
	}
}
