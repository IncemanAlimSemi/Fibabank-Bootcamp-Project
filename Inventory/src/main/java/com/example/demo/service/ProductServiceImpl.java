package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	public  ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Override
	public List<ProductDto> findByCategoryId(long categoryId) {
		List<ProductDto> productDtos = new ArrayList<>();
		Iterable<Product> products = productRepository.findByCategoryId(categoryId);
		for (Product product : products) {
			ProductDto productDto = new ProductDto();
			productDto.setProductId(product.getProductId());
			productDto.setProductName(product.getProductName());
			productDto.setSalesPrice(product.getSalesPrice());
			productDtos.add(productDto);
		}
		
		return productDtos;
	}

	@Override
	public ProductDto findByProductId(long productId) {
		Optional<Product> optional = productRepository.findById(productId);
		if (optional.isPresent()) {
			Product product = optional.get();
			ProductDto productDto = new ProductDto();
			productDto.setProductId(product.getProductId());
			productDto.setProductName(product.getProductName());
			productDto.setSalesPrice(product.getSalesPrice());
			return productDto;
		}
		
		return null;
	}

}
