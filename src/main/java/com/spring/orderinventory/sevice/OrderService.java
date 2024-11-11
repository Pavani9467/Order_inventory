package com.spring.orderinventory.sevice;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.orderinventory.Exception.IdDoesNotPresentException;
import com.spring.orderinventory.dao.OrderDao;
import com.spring.orderinventory.dto.ResponseStructure;
import com.spring.orderinventory.entity.Order;

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
	
}
