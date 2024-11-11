package com.spring.orderinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.orderinventory.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Integer>{

}
