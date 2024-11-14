package com.spring.orderinventory.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.orderinventory.Exception.OrdersNotFoundException;
import com.spring.orderinventory.dto.ResponseStructure;
import com.spring.orderinventory.entity.Order;
import com.spring.orderinventory.entity.OrderItem;
import com.spring.orderinventory.repository.OrderRepository;
import com.spring.orderinventory.sevice.OrderService;


@RestController
public class OrderController {
	
	@Autowired
	OrderRepository orderRepository;
	
	 @Autowired
	 OrderService orderService;
	 
	 //gary.jenkins@internalmail
	 //select o.*,c.* from orders o join customers c on o.customer_id = c.customer_id where full_name = 'Peter Jones';
	 @GetMapping("/api/v1/orders/customer/{email}")
	 public ResponseEntity<ResponseStructure<List<Order>>> getOrderDetailsByCustomerId(@PathVariable String email) {
			return orderService.getOrderDetailsByCustomerId(email);
		}
	 

	 
	 
	//for post 
	 public OrderController(OrderService orderService) {
	        this.orderService = orderService;
	    }

	    @PostMapping("orders/{orderId}/addItem")
	    public ResponseEntity<Order> addItemToOrder(@PathVariable int orderId, @RequestBody OrderItem newOrderItem) {
	        try {
	            Order updatedOrder = orderService.addItemToOrder(orderId, newOrderItem);
	            return new ResponseEntity<>(updatedOrder, HttpStatus.CREATED);
	        } catch (OrdersNotFoundException e) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	  
}
