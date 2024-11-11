package com.spring.order_inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.order_inventory.entity.Store;

public interface StoreRepository extends JpaRepository<Store,Integer>{

}
