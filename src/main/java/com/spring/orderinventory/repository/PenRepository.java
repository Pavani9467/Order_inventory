package com.spring.orderinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.orderinventory.entity.Pen;
@Repository
public interface PenRepository extends JpaRepository<Pen, Long>{
	
}
