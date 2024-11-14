package com.spring.orderinventory.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.orderinventory.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{
	
}
