package com.example.demo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AddDto;
import com.example.demo.dto.CartDto;
import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.service.CommerceService;

@RestController
@RequestMapping("/commerce")
public class CommerceResource {

	private final CommerceService commerceService;

    public CommerceResource(CommerceService commerceService) {
        this.commerceService = commerceService;
    }
    
    @GetMapping("/inventory/categories")
    public List<CategoryDto> findAll() {
    	return commerceService.findAll();
    }
    
    @GetMapping("/inventory/products/{categoryId}")
    public List<ProductDto> findByCategoryId(@PathVariable(name = "categoryId") long categoryId) {
    	return commerceService.findByCategoryId(categoryId);
    }
    
    @GetMapping("/inventory/product/{productId}")
    public ProductDto findByProductId(@PathVariable(name = "productId") long productId) {
    	return commerceService.findByProductId(productId);
    }
    
    @GetMapping("/shopping/cart/create")
    public long createCart(@RequestParam(name = "customerName") String customerName) {
    	return commerceService.createCart(customerName);
    }
    
    @PostMapping("/shopping/cart/add")
    public void addCart(@RequestBody AddDto addDto) {
    	commerceService.addCart(addDto);
    }
    
    @DeleteMapping("/shopping/cart/{cartId}/remove/{productId}")
    public void deleteProductFromCartProduct(@PathVariable(name = "cartId") long cartId, 
			@PathVariable(name = "productId") long productId) {
    	commerceService.deleteProductFromCartProduct(cartId, productId);
    }
    
    @GetMapping("/shopping/checkout/{cartId}")
	public void checkout(@PathVariable(name = "cartId") long cartId) {
    	commerceService.checkout(cartId);
    }
    
    @GetMapping("/shopping/cart/find/{cartId}")
	public CartDto find(@PathVariable(name = "cartId") long cartId) {
    	return commerceService.find(cartId);
    }
}
