package com.spring.orderinventory.sevice;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.orderinventory.Exception.InvalidQuantityRangeException;
import com.spring.orderinventory.dao.OrderItemDao;
import com.spring.orderinventory.dto.ResponseStructure;
import com.spring.orderinventory.entity.Customer;

@Service
public class OrderItemService {

	@Autowired
    private OrderItemDao orderItemDao;
   
	public ResponseEntity<ResponseStructure<List<Customer>>> getCustomersByOrderQuantityRange(int minQuantity, int maxQuantity) {
        if (minQuantity < 0 || maxQuantity < 0 || minQuantity > maxQuantity) {
            throw new InvalidQuantityRangeException("Invalid quantity range. Please provide valid minimum and maximum quantities.");
        }
        
        List<Customer> customers = orderItemDao.getCustomersByOrderQuantityRange(minQuantity, maxQuantity);
        
        ResponseStructure<List<Customer>> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("Customers retrieved successfully.");
        responseStructure.setData(Collections.singletonList(customers));
        
        return ResponseEntity.ok(responseStructure);
    }
	
}
