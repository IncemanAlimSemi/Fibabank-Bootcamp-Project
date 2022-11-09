package com.example.demo.client;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.ProductDto;


@Controller
@RequestMapping("/inventory")
public class ProductClient {
	
	@GetMapping("/products/{categoryId}")
	@ResponseBody
	public List<ProductDto> getProducts(@PathVariable("categoryId") long categoryId) {
		String url = "http://localhost:8081/api/products/"+categoryId;
		RestTemplate restTemplate = new RestTemplate();
		List<ProductDto> productDtos = restTemplate.getForObject(url, List.class);
		return productDtos;
	}
	
	@GetMapping("/product/{productId}")
	@ResponseBody
	public ProductDto getProduct(@PathVariable("productId") long productId) {
		String url = "http://localhost:8081/api/product/"+productId;
		RestTemplate restTemplate = new RestTemplate();
		ProductDto productDto = restTemplate.getForObject(url, ProductDto.class);
		return productDto;
	}
}
