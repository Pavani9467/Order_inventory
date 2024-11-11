package com.spring.order_inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.order_inventory.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	
	

}
