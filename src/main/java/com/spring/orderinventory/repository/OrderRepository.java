package com.spring.orderinventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.orderinventory.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{

//	@Query("SELECT o FROM Order o JOIN o.customer c WHERE c.emailAddress = :email")
//    List<Order> findOrdersByCustomerEmail(@Param("email") String email);

	
//	@Query("SELECT o FROM Order o JOIN o.customer c WHERE c.emailAddress = :email")
//	List<Order> findOrdersByCustomerEmail(@Param("email") String email);

	
//	@Query("SELECT o FROM Order o JOIN o.customer c WHERE c.emailAddress IN ?1")
//	List<Order> findOrdersByCustomerEmail(String email);
	

//	@Query("SELECT o FROM Order o JOIN o.customer c WHERE c.emailAddress = :email")
//    List<Order> findOrdersByCustomerEmail(@Param("email") String email);
	
//	@Query("SELECT o FROM Order o JOIN o.customer c WHERE LOWER(c.emailAddress) = LOWER(:email)")
//	List<Order> findOrdersByCustomerEmail(@Param("email") String email);
	
	@Query("SELECT o FROM Order o JOIN o.customer c WHERE c.emailAddress = :email")
    List<Order> findOrdersByCustomerEmail(@Param("email") String email);

	
	
}
