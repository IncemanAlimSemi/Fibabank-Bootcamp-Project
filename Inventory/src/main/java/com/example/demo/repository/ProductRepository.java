package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
	@Query("select p from Product p where p.category.categoryId = :categoryId")
	Iterable<Product> findByCategoryId(@Param("categoryId")long categoryId);
	
	

}
