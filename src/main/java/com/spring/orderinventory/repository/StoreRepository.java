package com.spring.orderinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.orderinventory.entity.Store;

public interface StoreRepository extends JpaRepository<Store,Integer>{

}
