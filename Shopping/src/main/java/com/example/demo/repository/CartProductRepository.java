package com.example.demo.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.CartProductDto;
import com.example.demo.entity.CartProduct;

@Transactional
public interface CartProductRepository extends CrudRepository<CartProduct, Long> {

	@Modifying
	@Query("delete from CartProduct as c where c.cart.cartId = :cartId and c.productId = :productId")
	void deleteProductFromCartProduct(@Param("cartId") long cartId, @Param("productId") long productId);
	
	@Query("select c from CartProduct as c where c.cart.cartId = :cartId and c.productId = :productId")
	CartProduct selectByCartIdAndProductId(@Param("cartId") long cartId, @Param("productId") long productId);
}
