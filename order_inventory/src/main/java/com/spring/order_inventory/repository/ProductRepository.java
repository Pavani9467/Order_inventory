package com.spring.order_inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.order_inventory.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

}
