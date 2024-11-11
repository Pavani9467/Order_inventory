package com.spring.orderinventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.orderinventory.dto.ResponseStructure;
import com.spring.orderinventory.entity.Customer;
import com.spring.orderinventory.sevice.OrderItemService;

@RestController
public class OrderItemController {

	@Autowired
    private OrderItemService orderItemService;

    @GetMapping("/api/v1/customers/orders/quantity/{min}/{max}")
    public ResponseEntity<ResponseStructure<List<Customer>>> getCustomersByOrderQuantityRange(
            @PathVariable int min,
            @PathVariable int max) {
        
        return orderItemService.getCustomersByOrderQuantityRange(min, max);
       
    }

	
}
