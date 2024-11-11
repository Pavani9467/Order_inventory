package com.spring.orderinventory.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.orderinventory.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	
	

}
