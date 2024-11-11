package com.spring.order_inventory.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.order_inventory.entity.Order;
import com.spring.order_inventory.repository.OrderRepository;

@Repository
public class OrderDao {
	@Autowired
	OrderRepository orderRepository;
	
	public List<Order> findingOrders(String email){
		List<Order> list = orderRepository.findOrdersByCustomerEmail(email);
		
		if(list.isEmpty()) {
			return null;
		}
		else {
			return list;
		}
	}
	
	
	
}
