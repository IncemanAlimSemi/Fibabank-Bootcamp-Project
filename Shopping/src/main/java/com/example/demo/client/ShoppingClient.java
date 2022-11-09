package com.example.demo.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.AddDto;
import com.example.demo.dto.CartDto;

@Controller
public class ShoppingClient {

	@GetMapping("/shopping/cart/create")
	@ResponseBody
	public long createCart(@RequestParam(name = "customerName") String customerName) {
		String url = "http://localhost:8082/api/create?customerName="+customerName;
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, Long.class);
	}
	
	@GetMapping("/shopping/cart/add")
	@ResponseBody
	public void addCart(@RequestBody AddDto addDto) {
		String url = "http://localhost:8082/api/add";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(url, addDto, Void.class);
	}
	
	@GetMapping("/shopping/cart/{cartId}/remove/{productId}")
	@ResponseBody
	public void deleteProductFromCartProduct(@PathVariable(name = "cartId") long cartId, 
			@PathVariable(name = "productId") long productId) {
		String url = "http://localhost:8082/api/delete/" + cartId + "/" + productId;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
	}
	
	@GetMapping("/shopping/checkout/{cartId}")
	@ResponseBody
	public void checkout(@PathVariable(name = "cartId") long cartId) {
		String url = "http://localhost:8082/api/checkout/" + cartId;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForObject(url, Void.class);
	}
	
	@GetMapping("/shopping/cart/find/{cartId}")
	@ResponseBody
	public CartDto find(@PathVariable(name = "cartId") long cartId) {
		String url = "http://localhost:8082/api/find/" + cartId;
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, CartDto.class);
	}
}
