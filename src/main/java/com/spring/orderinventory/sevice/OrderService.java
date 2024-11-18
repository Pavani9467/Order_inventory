package com.spring.orderinventory.sevice;

import java.util.Collections;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.orderinventory.Exception.IdDoesNotPresentException;
import com.spring.orderinventory.Exception.NoCompletedOrdersException;
import com.spring.orderinventory.Exception.OrdersNotFoundException;

import com.spring.orderinventory.dao.OrderDao;

import com.spring.orderinventory.dto.ResponseStructure;
import com.spring.orderinventory.entity.Customer;
import com.spring.orderinventory.entity.Order;
import com.spring.orderinventory.entity.OrderItem;

import com.spring.orderinventory.repository.OrderItemsRepository;
import com.spring.orderinventory.repository.OrderRepository;


@Service
public class OrderService {

	@Autowired
	OrderDao orderDao;
	
	public ResponseEntity<ResponseStructure<List<Order>>> getOrderDetailsByCustomerId(String email) 
	{
	    List<Order> orderDetails = orderDao.findingOrders(email);
	    
	    	if (orderDetails != null && !orderDetails.isEmpty()) {
	        ResponseStructure<List<Order>> responseStructure = new ResponseStructure<>();
	        responseStructure.setStatusCode(HttpStatus.OK.value());
	        responseStructure.setMessage("Success");
	        responseStructure.setData(Collections.singletonList(orderDetails));  // Directly setting the list of orders here
	        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	    }
	    else{
	        throw new IdDoesNotPresentException("Shipment history for the specified customer ID = " + email + " not found.");
	    }
	
	
	}
	
	
	
	// for post
    private final OrderRepository orderRepository;
    private final OrderItemsRepository orderItemRepository;

    public OrderService(OrderRepository orderRepository, OrderItemsRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public Order addItemToOrder(int orderId, OrderItem newOrderItem) throws OrdersNotFoundException {
        // Check if the order exists
        Order existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrdersNotFoundException("Order ID not found"));

        // Set the order for the new order item
        newOrderItem.setOrder(existingOrder);

        // Save the new order item
        orderItemRepository.save(newOrderItem);

        // Re-fetch the updated order with the new order items
        existingOrder.getOrderItems().add(newOrderItem);

        return orderRepository.save(existingOrder); // Return the updated order with the new item
    }


    
    public ResponseStructure<Customer> getCustomersWithCompletedOrders() {
        List<Customer> customers = orderDao.findCustomersWithCompletedOrders();

        if (customers.isEmpty()) {
            throw new NoCompletedOrdersException("No customers with completed orders found");
        }

        ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("Successfully fetched customers with completed orders");
        responseStructure.setData(customers);

        return responseStructure;
    }
   
    
}
	

