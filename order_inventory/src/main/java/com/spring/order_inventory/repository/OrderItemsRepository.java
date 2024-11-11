package com.spring.order_inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.order_inventory.entity.Customer;
import com.spring.order_inventory.entity.OrderItem;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItem,Integer>{

	@Query("SELECT o.customer FROM OrderItem oi " +
	           "JOIN oi.order o " +
	           "WHERE oi.quantity BETWEEN :minQuantity AND :maxQuantity")
	List<Customer> findCustomersByOrderQuantityRange(int minQuantity, int maxQuantity);
	
}
