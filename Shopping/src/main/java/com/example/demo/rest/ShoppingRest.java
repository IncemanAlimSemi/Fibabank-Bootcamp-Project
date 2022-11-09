package com.example.demo.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AddDto;
import com.example.demo.dto.CartDto;
import com.example.demo.service.ShoppingService;

@RestController
public class ShoppingRest {

	private ShoppingService shoppingService;
	
	public ShoppingRest(ShoppingService shoppingService) {
		this.shoppingService = shoppingService;
	}
	
	@GetMapping("/api/create")
	public long createCart(@RequestParam String customerName) {
		return shoppingService.createCart(customerName);
	}
	
	
	@PostMapping("/api/add")
	public void addCart(@RequestBody AddDto addDto) {
		shoppingService.addCart(addDto);
	}
	
	@DeleteMapping("/api/delete/{cartId}/{productId}")
	public void deleteProductFromCartProduct(@PathVariable(name = "cartId") long cartId, @PathVariable(name = "productId") long productId) {
		shoppingService.deleteProductFromCartProduct(cartId, productId);
	}
	
	@GetMapping("/api/checkout/{cartId}")
	public void checkout(@PathVariable(name = "cartId") long cartId) {
		shoppingService.checkout(cartId);
	}
	
	@GetMapping("/api/find/{cartId}")
	public CartDto find(@PathVariable(name = "cartId") long cartId) {
		CartDto cartDto = shoppingService.find(cartId);
		return cartDto;
	}
}
