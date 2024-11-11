package com.spring.order_inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.spring.order_inventory.dto.ResponseStructure;
import com.spring.order_inventory.entity.Order;
import com.spring.order_inventory.repository.OrderRepository;
import com.spring.order_inventory.sevice.OrderService;


@RestController
public class OrderController {
	
	@Autowired
	OrderRepository orderRepository;
	
//	@GetMapping("/api/v1/orders/customer/{email}")
//	public List<Order> methodR(@PathVariable String email){
//		List<Order> orders = orderRepository.findOrdersByCustomerEmail(email);
//		return orders;
//	}
	
	
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/jesus123/{email}")
	public ResponseEntity<ResponseStructure<List<Order>>> getOrderDetailsByCustomerId(@PathVariable String email) {
		return orderService.getOrderDetailsByCustomerId(email);
	}
	
	
}
