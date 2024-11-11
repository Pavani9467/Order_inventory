package com.spring.order_inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.order_inventory.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{

//	@Query("SELECT o FROM Order o JOIN o.customer c WHERE c.emailAddress = :email")
//    List<Order> findOrdersByCustomerEmail(@Param("email") String email);
	
//	@Query("SELECT c FROM Order o JOIN o.customer c WHERE c.emailAddress = :email")
//    List<Order> findOrdersByCustomerEmail(@Param("email") String email);
	
	@Query("SELECT o FROM Order o JOIN o.customer c WHERE c.emailAddress = :email")
	List<Order> findOrdersByCustomerEmail(@Param("email") String email);

	
}
