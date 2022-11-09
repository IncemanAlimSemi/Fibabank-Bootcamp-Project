package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AddDto;
import com.example.demo.dto.CartDto;
import com.example.demo.dto.CartProductDto;
import com.example.demo.entity.Cart;
import com.example.demo.entity.CartProduct;
import com.example.demo.repository.CartProductRepository;
import com.example.demo.repository.CartRepository;

@Service
public class ShoppingServiceImpl implements ShoppingService {

	private CartRepository cartRepository;
	private CartProductRepository cartProductRepository;	
	
	public ShoppingServiceImpl(CartRepository cartRepository, CartProductRepository cartProductRepository) {
		this.cartRepository = cartRepository;
		this.cartProductRepository = cartProductRepository;
	}

	@Override
	public long createCart(String customerName) {
		Cart cart = new Cart();
		cart.setCustomerName(customerName);
		cart.setCartStatus(false);
		cart.setTotalAmount(0);
		cartRepository.save(cart);
		return cart.getCartId();
	}

	@Override
	public void addCart(AddDto addDto) {
		CartProduct cartProduct = new CartProduct();
		cartProduct.setProductId(addDto.getProductId());
		cartProduct.setSalesPrice(addDto.getSalesPrice());
		cartProduct.setSalesQuantity(addDto.getSalesQuantity());
		cartProduct.setLineAmount(addDto.getSalesQuantity() * addDto.getSalesPrice());
		
		Optional<Cart> optional= cartRepository.findById(addDto.getCartId());
		if(optional.isPresent()) {
			Cart cart = optional.get();
			cart.setTotalAmount(cart.getTotalAmount() + cartProduct.getLineAmount());
			cartProduct.setCart(cart);
		}

		cartProductRepository.save(cartProduct);
	}

	@Override
	public void deleteProductFromCartProduct(long cartId, long productId) {
		CartProduct cartProduct = cartProductRepository.selectByCartIdAndProductId(cartId, productId);
		Optional<Cart> optional= cartRepository.findById(cartId);
		if(optional.isPresent()) {
			Cart cart = optional.get();
			cart.setTotalAmount(cart.getTotalAmount() - cartProduct.getLineAmount());
			cartRepository.save(cart);
		}
		cartProductRepository.deleteProductFromCartProduct(cartId, productId);	
	}

	@Override
	public void checkout(long cartId) {
		Optional<Cart> optional = cartRepository.findById(cartId);
		if(optional.isPresent()) {
			Cart cart = optional.get();
			cart.setCartStatus(true);
			cartRepository.save(cart);
		}
		
	}

	@Override
	public CartDto find(long cartId) {
		Optional<Cart> optional = cartRepository.findById(cartId);
		
		if(optional.isPresent()) {
			
			double totalAmount = 0;
			Cart cart = optional.get();
			
			List<CartProduct> cartProducts = cart.getCartProducts();
			List<CartProductDto> cartProductDtos = new ArrayList<>();
			
			for (CartProduct cartProduct : cartProducts) {
				CartProductDto cartProductDto = new CartProductDto();
				cartProductDto.setCartProductId(cartProduct.getCartProductId());
				cartProductDto.setLineAmount(cartProduct.getLineAmount());
				cartProductDto.setProductId(cartProduct.getProductId());
				cartProductDto.setSalesPrice(cartProduct.getSalesPrice());
				cartProductDto.setSalesQuantity(cartProduct.getSalesQuantity());
				cartProductDtos.add(cartProductDto);
				totalAmount += cartProduct.getLineAmount();
			}
			
			CartDto cartDto = new CartDto();
			cartDto.setCartId(cartId);
			cartDto.setCustomerName(cart.getCustomerName());
			cartDto.setTotalAmount(totalAmount);
			cartDto.setCartProducts(cartProductDtos);
			
			return cartDto;
		}
		return null;
	}
	
	
	
	
	
	
}
