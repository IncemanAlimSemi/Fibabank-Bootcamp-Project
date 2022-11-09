package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.AddDto;
import com.example.demo.dto.CartDto;
import com.example.demo.dto.CartProductDto;
import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.ProductDto;

@Service
public class CommerceServiceImpl implements CommerceService {

	@Override
	public List<CategoryDto> findAll() {
		String url = "http://localhost:8081/api/categories";
		RestTemplate restTemplate = new RestTemplate();
		List<CategoryDto> categoryDtos = restTemplate.getForObject(url, List.class);
		return categoryDtos;
	}

	@Override
	public List<ProductDto> findByCategoryId(long categoryId) {
		String url = "http://localhost:8081/api/products/"+categoryId;
		RestTemplate restTemplate = new RestTemplate();
		List<ProductDto> productDtos = restTemplate.getForObject(url, List.class);
		return productDtos;
	}

	@Override
	public ProductDto findByProductId(long productId) {
		String url = "http://localhost:8081/api/product/"+productId;
		RestTemplate restTemplate = new RestTemplate();
		ProductDto productDto = restTemplate.getForObject(url, ProductDto.class);
		return productDto;
	}

	@Override
	public long createCart(String customerName) {
		String url = "http://localhost:8082/api/create?customerName="+customerName;
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, Long.class);
	}

	@Override
	public void addCart(AddDto addDto) {
		String url = "http://localhost:8082/api/add";
		RestTemplate restTemplate = new RestTemplate();
		
		ProductDto productDto = findByProductId(addDto.getProductId());
		addDto.setSalesPrice(productDto.getSalesPrice());
		
		restTemplate.postForObject(url, addDto, Void.class);
	}

	@Override
	public void deleteProductFromCartProduct(long cartId, long productId) {
		String url = "http://localhost:8082/api/delete/" + cartId + "/" + productId;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
	}

	@Override
	public void checkout(long cartId) {
		String url = "http://localhost:8082/api/checkout/" + cartId;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForObject(url, Void.class);
	}

	@Override
	public CartDto find(long cartId) {
		
		String url = "http://localhost:8082/api/find/" + cartId;
		RestTemplate restTemplate = new RestTemplate();
		CartDto cartDto = restTemplate.getForObject(url, CartDto.class);
		List<CartProductDto> cartProductDtos = cartDto.getCartProducts();
		List<CartProductDto> newCartProductDtos = new ArrayList<>();
		
		for (CartProductDto cartProductDto : cartProductDtos) {
			ProductDto productDto = findByProductId(cartProductDto.getProductId());
			cartProductDto.setProductName(productDto.getProductName());
			newCartProductDtos.add(cartProductDto);
		}
		
		cartDto.setCartProducts(newCartProductDtos);
		
		return cartDto;
	}

	
}
