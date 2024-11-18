package com.spring.orderinventory.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.orderinventory.entity.Customer;
import com.spring.orderinventory.entity.Order;
import com.spring.orderinventory.repository.OrderRepository;

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
	
	public List<Customer> findCustomersWithCompletedOrders() {
        return orderRepository.findCustomersWithCompletedOrders();
    }
	
	
}
